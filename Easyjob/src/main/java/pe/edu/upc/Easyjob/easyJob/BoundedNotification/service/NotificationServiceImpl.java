package pe.edu.upc.Easyjob.easyJob.BoundedNotification.service;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.domain.model.entity.Announcement;
import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.domain.persistence.AnnouncementRepository;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.domain.model.entity.Application;
import pe.edu.upc.Easyjob.easyJob.BoundedCompany.domain.persistence.CompanyRepository;
import pe.edu.upc.Easyjob.easyJob.BoundedNotification.domain.model.entity.Notification;
import pe.edu.upc.Easyjob.easyJob.BoundedNotification.domain.persistence.NotificationRepository;
import pe.edu.upc.Easyjob.easyJob.BoundedNotification.domain.service.NotificationService;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.persistence.PostulantRepository;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.domain.model.entity.Project;
import pe.edu.upc.Easyjob.shared.exception.ResourceNotFoundException;
import pe.edu.upc.Easyjob.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
@Service
public class NotificationServiceImpl implements NotificationService {
    private static final String ENTITY = "Notification";

    private final NotificationRepository notificationRepository;
    private final CompanyRepository companyRepository;
    private final AnnouncementRepository announcementRepository;
    private final PostulantRepository postulantRepository;

    private final Validator validator;
    public NotificationServiceImpl(NotificationRepository notificationRepository,
                                   CompanyRepository companyRepository ,
                                   AnnouncementRepository announcementRepository,PostulantRepository postulantRepository,Validator validator) {
        this.notificationRepository = notificationRepository;
        this.validator = validator;
        this.companyRepository=companyRepository;
        this.announcementRepository=announcementRepository;
        this.postulantRepository=postulantRepository;
    }

    @Override
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    @Override
    public Page<Notification> getAll(Pageable pageable) {
        return notificationRepository.findAll(pageable);
    }

    @Override
    public List<Notification> getByCompanyIdAndType(Long companyId, String type) {
        return notificationRepository.findByCompanyIdAndType(companyId,type);
    }

    @Override
    public Page<Notification> getByCompanyIdAndType(Long companyId, String type, Pageable pageable) {
        return notificationRepository.findByCompanyIdAndType(companyId,type,pageable);
    }

    @Override
    public List<Notification> getByPostulantIdAndTypeNot(Long postulantId, String type) {
        return notificationRepository.findByPostulantIdAndTypeNot(postulantId,type);
    }

    @Override
    public Page<Notification> getByPostulantIdAndTypeNot(Long postulantId, String type, Pageable pageable) {
        return notificationRepository.findByPostulantIdAndTypeNot(postulantId,type,pageable);
    }

    @Override
    public Notification create(Long companyId, Long announcementId, Long postulantId, Notification request) {
        Set<ConstraintViolation<Notification>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return companyRepository.findById(companyId).map(company -> {
            request.setCompany(company);
            return announcementRepository.findById(announcementId).map(announcement -> {
                request.setAnnouncement(announcement);
                return postulantRepository.findById(postulantId).map(postulant -> {
                    request.setPostulant(postulant);
                    return notificationRepository.save(request);
                }).orElseThrow(() -> new ResourceNotFoundException("Postulant", postulantId ));
            }).orElseThrow(() -> new ResourceNotFoundException("Announcement", announcementId ));

        }).orElseThrow(() -> new ResourceNotFoundException("Company", companyId ));
    }

    @Override
    public Notification getById(Long notificationId) {
        return notificationRepository.findById(notificationId).orElseThrow(()->new ResourceNotFoundException(ENTITY,notificationId));
    }

    @Override
    public Notification update(Long notificationId, Notification request) {
        Set<ConstraintViolation<Notification>> violations = validator.validate(request);
        return notificationRepository.findById(notificationId).map(notification ->
                notificationRepository.save(
                        notification.withType(request.getType()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, notificationId));
    }

    @Override
    public ResponseEntity<?> delete(Long notificationId) {
        return notificationRepository.findById(notificationId).map(notification -> {
            notificationRepository.delete(notification);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, notificationId));
    }
}
