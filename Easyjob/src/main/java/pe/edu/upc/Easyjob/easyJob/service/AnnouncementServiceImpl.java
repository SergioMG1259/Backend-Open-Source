package pe.edu.upc.Easyjob.easyJob.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pe.edu.upc.Easyjob.easyJob.domain.model.entity.Announcement;
import pe.edu.upc.Easyjob.easyJob.domain.persistence.AnnouncementRepository;
import pe.edu.upc.Easyjob.easyJob.domain.persistence.CompanyRepository;
import pe.edu.upc.Easyjob.easyJob.domain.service.AnnouncementService;
import pe.edu.upc.Easyjob.shared.exception.ResourceNotFoundException;
import pe.edu.upc.Easyjob.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
@Service
public class AnnouncementServiceImpl implements AnnouncementService{
    private static final String ENTITY = "Announcement";

    private final AnnouncementRepository announcementRepository;

    private final CompanyRepository companyRepository;

    private final Validator validator;
    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository, Validator validator, CompanyRepository companyRepository) {
        this.announcementRepository = announcementRepository;
        this.companyRepository=companyRepository;
        this.validator = validator;
    }

    @Override
    public List<Announcement> getAllByCompanyId(Long companyId) {
        return announcementRepository.findByCompanyId(companyId);
    }

    @Override
    public Page<Announcement> getAllByCompanyId(Long companyId, Pageable pageable) {
        return announcementRepository.findByCompanyId(companyId,pageable);
    }

    @Override
    public Announcement create(Long companyId, Announcement request) {
        Set<ConstraintViolation<Announcement>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return companyRepository.findById(companyId).map(company -> {
            request.setCompany(company);
            return announcementRepository.save(request);
        }).orElseThrow(() -> new ResourceNotFoundException("Company", companyId ));
    }

    @Override
    public Announcement getByIdAndCompanyId(Long companyId, Long announcementId) {
        return announcementRepository.findByIdAndCompanyId(announcementId, companyId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, companyId));
    }

    @Override
    public Announcement update(Long companyId, Long announcementId, Announcement request) {
        /*Set<ConstraintViolation<Announcement>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);*/

        if(!companyRepository.existsById(companyId))
            throw new ResourceNotFoundException("Company", companyId);

        return announcementRepository.findById(announcementId).map(announcement ->
                announcementRepository.save(
                        announcement.withTitle(request.getTitle())
                                .withDescription(request.getDescription())
                                .withRequiredexperience(request.getRequiredexperience())
                                .withRequiredspecialty(request.getRequiredspecialty())
                                .withSalary(request.getSalary())
                                .withTypemoney(request.getTypemoney())
                                .withVisible(request.getVisible()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, announcementId));
    }

    @Override
    public ResponseEntity<?> delete(Long companyId, Long announcementId) {
        return announcementRepository.findByIdAndCompanyId(announcementId, companyId).map(announcement -> {
            announcementRepository.delete(announcement);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, announcementId));
    }
}
