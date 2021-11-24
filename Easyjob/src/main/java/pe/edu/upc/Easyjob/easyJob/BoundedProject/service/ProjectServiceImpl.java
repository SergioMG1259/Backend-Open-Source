package pe.edu.upc.Easyjob.easyJob.BoundedProject.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pe.edu.upc.Easyjob.easyJob.BoundedProject.domain.model.entity.Project;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.domain.persistence.ProjectResporitory;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.persistence.PostulantRepository;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.domain.service.ProjectService;
import pe.edu.upc.Easyjob.shared.exception.ResourceNotFoundException;
import pe.edu.upc.Easyjob.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService{
    private static final String ENTITY = "Project";

    private final ProjectResporitory projectResporitory;

    private final PostulantRepository postulantResporitory;

    private final Validator validator;
    public ProjectServiceImpl(ProjectResporitory projectResporitory, Validator validator,PostulantRepository postulantResporitory) {
        this.projectResporitory = projectResporitory;
        this.postulantResporitory=postulantResporitory;
        this.validator = validator;
    }
    @Override
    public List<Project> getAll() {
        return projectResporitory.findAll();
    }
    @Override
    public Page<Project> getAll(Pageable pageable) {
        return projectResporitory.findAll(pageable);
    }
    @Override
    public List<Project> getAllByPostulantId(Long postulantId) {
        return projectResporitory.findByPostulantId(postulantId);
    }
    @Override
    public Page<Project> getAllByPostulantId(Long postulantId, Pageable pageable) {
        return projectResporitory.findByPostulantId(postulantId, pageable);
    }

    @Override
    public Project create(Long postulantId, Project request) {
        Set<ConstraintViolation<Project>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return postulantResporitory.findById(postulantId).map(postulant -> {
            request.setPostulant(postulant);
            return projectResporitory.save(request);
        }).orElseThrow(() -> new ResourceNotFoundException("Postulant", postulantId ));
    }

    @Override
    public Project getById(Long projectId) {
        return projectResporitory.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, projectId));
    }

    @Override
    public Project update(Long projectId, Project request) {
        Set<ConstraintViolation<Project>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        /*if(!postulantResporitory.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant", postulantId);*/

        return projectResporitory.findById(projectId).map(project ->
                projectResporitory.save(
                        project.withDescription(request.getDescription())
                                .withTitle(request.getTitle())
                                .withImgProject(request.getImgProject())
                                .withLinkToGithub(request.getLinkToGithub()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, projectId));
    }

    @Override
    public ResponseEntity<?> delete(Long projectId) {
        return projectResporitory.findById(projectId).map(project -> {
            projectResporitory.delete(project);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, projectId));
    }
}
