package pe.edu.upc.Easyjob.easyJob.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.Easyjob.easyJob.domain.model.entity.Postulant;
import pe.edu.upc.Easyjob.easyJob.domain.persistence.PostulantRepository;
import pe.edu.upc.Easyjob.easyJob.domain.service.PostulantService;
import pe.edu.upc.Easyjob.shared.exception.ResourceNotFoundException;
import pe.edu.upc.Easyjob.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
@Service
public class PostulantServiceImpl implements PostulantService {
    private static final String ENTITY = "Postulant";

    private final PostulantRepository postulantRepository;

    private final Validator validator;

    public PostulantServiceImpl(PostulantRepository postulantRepository, Validator validator) {
        this.postulantRepository = postulantRepository;
        this.validator = validator;
    }

    @Override
    public List<Postulant> getAll() {
        return postulantRepository.findAll();
    }
    @Override
    public Page<Postulant> getAll(Pageable pageable) {
        return postulantRepository.findAll(pageable);
    }
    @Override
    public Postulant getById(Long postulantId) {
        return postulantRepository.findById(postulantId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,postulantId));
    }
    @Override
    public Postulant create(Postulant request) {
        Set<ConstraintViolation<Postulant>>violations=validator.validate(request);
        if (!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY,violations);
        }
        return postulantRepository.save(request);
    }

    @Override
    public Postulant update(Long postulantId, Postulant request) {
        Set<ConstraintViolation<Postulant>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return postulantRepository.findById(postulantId).map(postulant ->
                postulantRepository.save(
                        postulant.withName(request.getName())
                                .withLastname(request.getLastname())
                                .withImgpostulant(request.getImgpostulant())
                                .withDescription(request.getDescription())
                                .withNamegithub(request.getNamegithub()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, postulantId));
    }

    @Override
    public ResponseEntity<?> delete(Long postulantId) {
        return postulantRepository.findById(postulantId).map(postulant -> {
            postulantRepository.delete(postulant);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, postulantId));
    }
}
