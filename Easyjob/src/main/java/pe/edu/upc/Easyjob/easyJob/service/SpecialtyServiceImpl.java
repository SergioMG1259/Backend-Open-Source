package pe.edu.upc.Easyjob.easyJob.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pe.edu.upc.Easyjob.easyJob.domain.model.entity.Project;
import pe.edu.upc.Easyjob.easyJob.domain.model.entity.Specialty;
import pe.edu.upc.Easyjob.easyJob.domain.persistence.SpecialtyRepository;
import pe.edu.upc.Easyjob.easyJob.domain.persistence.PostulantRepository;
import pe.edu.upc.Easyjob.easyJob.domain.service.SpecialtyService;
import pe.edu.upc.Easyjob.shared.exception.ResourceNotFoundException;
import pe.edu.upc.Easyjob.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class SpecialtyServiceImpl implements SpecialtyService{
    private static final String ENTITY = "Specialty";

    private final SpecialtyRepository specialtyRepository;

    private final PostulantRepository postulantResporitory;

    private final Validator validator;
    public SpecialtyServiceImpl(SpecialtyRepository specialtyRepository, Validator validator,PostulantRepository postulantResporitory) {
        this.specialtyRepository = specialtyRepository;
        this.postulantResporitory=postulantResporitory;
        this.validator = validator;
    }

    @Override
    public List<Specialty> getAllByPostulantId(Long postulantId) {
        return specialtyRepository.findByPostulantId(postulantId);
    }

    @Override
    public Page<Specialty> getAllByPostulantId(Long postulantId, Pageable pageable) {
        return specialtyRepository.findByPostulantId(postulantId,pageable);
    }

    @Override
    public Specialty create(Long postulantId, Specialty request) {
        Set<ConstraintViolation<Specialty>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return postulantResporitory.findById(postulantId).map(postulant -> {
            request.setPostulant(postulant);
            return specialtyRepository.save(request);
        }).orElseThrow(() -> new ResourceNotFoundException("Postulant", postulantId ));
    }

    @Override
    public Specialty getByIdAndPostulantId(Long postulantId, Long specialtyId) {
        return specialtyRepository.findByIdAndPostulantId(specialtyId, postulantId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, specialtyId));
    }

    @Override
    public Specialty update(Long postulantId, Long specialtyId, Specialty request) {
        Set<ConstraintViolation<Specialty>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if(!postulantResporitory.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant", postulantId);

        return specialtyRepository.findById(specialtyId).map(specialty ->
                specialtyRepository.save(
                        specialty.withSpecialty(request.getSpecialty())
                                .withExperience(request.getExperience()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, specialtyId));
    }

    @Override
    public ResponseEntity<?> delete(Long postulantId, Long specialtyId) {
        return specialtyRepository.findByIdAndPostulantId(specialtyId, postulantId).map(specialty -> {
            specialtyRepository.delete(specialty);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, specialtyId));
    }
}
