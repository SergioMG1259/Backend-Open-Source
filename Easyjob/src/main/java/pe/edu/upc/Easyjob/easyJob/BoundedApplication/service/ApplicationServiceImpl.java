package pe.edu.upc.Easyjob.easyJob.BoundedApplication.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.domain.persistence.AnnouncementRepository;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.domain.model.entity.Application;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.domain.persistence.ApplicationRepository;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.domain.service.ApplicationService;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.model.entity.Postulant;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.persistence.PostulantRepository;
import pe.edu.upc.Easyjob.shared.exception.ResourceNotFoundException;
import pe.edu.upc.Easyjob.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private static final String ENTITY = "Application";

    private final ApplicationRepository applicationRepository;

    private final PostulantRepository postulantRepository;

    private final AnnouncementRepository announcementRepository;

    private final Validator validator;
    public ApplicationServiceImpl(ApplicationRepository applicationRepository, Validator validator, PostulantRepository postulantRepository,AnnouncementRepository announcementRepository) {
        this.applicationRepository = applicationRepository;
        this.postulantRepository=postulantRepository;
        this.announcementRepository=announcementRepository;
        this.validator = validator;
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Page<Application> getAllApplications(Pageable pageable) {
        return applicationRepository.findAll(pageable);
    }

    @Override
    public List<Application> getApplicationsByAnnouncementId(Long announcementId) {
        return applicationRepository.findByAnnouncementId(announcementId);
    }

    @Override
    public Page<Application> getApplicationsByAnnouncementId(Long announcementId, Pageable pageable) {
        return applicationRepository.findByAnnouncementId(announcementId,pageable);
    }

    @Override
    public List<Application> getApplicationsByAnnouncementIdAndPostulantId(Long announcementId, Long postulantId) {
        return applicationRepository.findByAnnouncementIdAndPostulantId(announcementId,postulantId);
    }

    @Override
    public Page<Application> getApplicationsByAnnouncementIdAndPostulantId(Long announcementId, Long postulantId, Pageable pageable) {
        return applicationRepository.findByAnnouncementIdAndPostulantId(announcementId,postulantId,pageable);
    }

    @Override
    public Postulant getByPostulantId(Long id) {
        return postulantRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(ENTITY,id));
    }

    @Override
    public Application create(Long announcementId, Long postulantId, Application request) {
        Set<ConstraintViolation<Application>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return postulantRepository.findById(postulantId).map(postulant -> {
            request.setPostulant(postulant);
            return announcementRepository.findById(announcementId).map(announcement ->{
                request.setAnnouncement(announcement);
                return applicationRepository.save(request);
            }).orElseThrow(() -> new ResourceNotFoundException("Announcement", announcementId ));
        }).orElseThrow(() -> new ResourceNotFoundException("Postulant", postulantId ));
    }

    @Override
    public Application getById(Long applicationtId) {
        return applicationRepository.findById(applicationtId).orElseThrow(()->new ResourceNotFoundException(ENTITY,applicationtId));
    }

    @Override
    public Application update(Long applicationId, Application request) {
        Set<ConstraintViolation<Application>> violations = validator.validate(request);
        return applicationRepository.findById(applicationId).map(application ->
                applicationRepository.save(
                        application.withStatus(request.getStatus()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, applicationId));
    }

    @Override
    public ResponseEntity<?> delete(Long applicationId) {
        return applicationRepository.findById(applicationId).map(application -> {
            applicationRepository.delete(application);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, applicationId));
    }
}
