package pe.edu.upc.Easyjob.easyJob.BoundedPostulant.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.model.entity.Specialty;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.persistence.PostulantRepository;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.persistence.SpecialtyRepository;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.service.SpecialtyService;
import pe.edu.upc.Easyjob.shared.exception.ResourceNotFoundException;
import pe.edu.upc.Easyjob.shared.exception.ResourceValidationException;

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
    public Specialty getById(Long specialtyId) {
        return specialtyRepository.findById(specialtyId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, specialtyId));
    }

    @Override
    public Specialty update(Long specialtyId, Specialty request) {
        Set<ConstraintViolation<Specialty>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        /*if(!postulantResporitory.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant", postulantId);*/

        return specialtyRepository.findById(specialtyId).map(specialty ->
                specialtyRepository.save(
                        specialty.withSpecialty(request.getSpecialty())
                                .withExperience(request.getExperience()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, specialtyId));
    }

    @Override
    public ResponseEntity<?> delete(Long specialtyId) {
        return specialtyRepository.findById(specialtyId).map(specialty -> {
            specialtyRepository.delete(specialty);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, specialtyId));
    }

    @Override
    public List<Specialty> getBySpecialtyOrExperience(String specialty,String experience) {
        return specialtyRepository.findBySpecialtyOrExperience(specialty,experience);
    }

    @Override
    public Page<Specialty> getBySpecialtyOrExperience(String specialty,String experience, Pageable pageable) {
        return specialtyRepository.findBySpecialtyOrExperience(specialty,experience,pageable);
    }
}
