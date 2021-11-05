package pe.edu.upc.Easyjob.easyJob.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pe.edu.upc.Easyjob.easyJob.domain.model.entity.Evidence;
import pe.edu.upc.Easyjob.easyJob.domain.persistence.EvidenceRepository;
import pe.edu.upc.Easyjob.easyJob.domain.persistence.ProjectResporitory;
import pe.edu.upc.Easyjob.easyJob.domain.service.EvidenceService;
import pe.edu.upc.Easyjob.shared.exception.ResourceNotFoundException;
import pe.edu.upc.Easyjob.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
@Service
public class EvidenceServiceImpl implements EvidenceService {
    private static final String ENTITY = "Evidence";

    private final EvidenceRepository evidenceRepository;

    private final ProjectResporitory projectResporitory;

    private final Validator validator;
    public EvidenceServiceImpl(EvidenceRepository evidenceRepository, Validator validator,ProjectResporitory projectResporitory) {
        this.evidenceRepository = evidenceRepository;
        this.projectResporitory=projectResporitory;
        this.validator = validator;
    }

    @Override
    public List<Evidence> getAllByProjectId(Long projectId) {
        return evidenceRepository.findByProjectId(projectId);
    }

    @Override
    public Page<Evidence> getAllByProjectId(Long projectId, Pageable pageable) {
        return evidenceRepository.findByProjectId(projectId,pageable);
    }

    @Override
    public Evidence create(Long projectId, Evidence request) {
        Set<ConstraintViolation<Evidence>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return projectResporitory.findById(projectId).map(project -> {
            request.setProject(project);
            return evidenceRepository.save(request);
        }).orElseThrow(() -> new ResourceNotFoundException("Project", projectId ));
    }

    @Override
    public Evidence getByIdAndProjectId(Long projectId, Long evidenceId) {
        return evidenceRepository.findByIdAndProjectId(evidenceId, projectId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, projectId));
    }

    @Override
    public Evidence update(Long projectId, Long evidenceId, Evidence request) {
        Set<ConstraintViolation<Evidence>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if(!projectResporitory.existsById(projectId))
            throw new ResourceNotFoundException("Project", projectId);

        return evidenceRepository.findById(evidenceId).map(evidence ->
                evidenceRepository.save(
                        evidence.withDescriptionevidence(request.getDescriptionevidence())
                                .withTitleevidence(request.getTitleevidence())
                                .withImgevidence(request.getImgevidence()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, evidenceId));
    }

    @Override
    public ResponseEntity<?> delete(Long projectId, Long evidenceId) {
        return evidenceRepository.findByIdAndProjectId(evidenceId, projectId).map(evidence -> {
            evidenceRepository.delete(evidence);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, evidenceId));
    }
}

