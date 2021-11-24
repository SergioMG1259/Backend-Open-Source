package pe.edu.upc.Easyjob.easyJob.BoundedPostulant.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.model.entity.Postulant;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.persistence.PostulantRepository;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.service.PostulantService;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.mapping.PostulantMapper;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.resource.AuthenticatePostulantRequest;
import pe.edu.upc.Easyjob.shared.exception.ResourceNotFoundException;
import pe.edu.upc.Easyjob.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class PostulantServiceImpl implements PostulantService {
    private static final String ENTITY = "Postulant";

    private final PostulantRepository postulantRepository;
    private final PostulantMapper mapper;
    private final Validator validator;

    public PostulantServiceImpl(PostulantRepository postulantRepository, PostulantMapper mapper, Validator validator) {
        this.postulantRepository = postulantRepository;
        this.mapper = mapper;
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
                                .withLastName(request.getLastName())
                                .withImgPostulant(request.getImgPostulant())
                                .withDescription(request.getDescription())
                                .withNameGithub(request.getNameGithub()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, postulantId));
    }

    @Override
    public ResponseEntity<?> delete(Long postulantId) {
        return postulantRepository.findById(postulantId).map(postulant -> {
            postulantRepository.delete(postulant);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, postulantId));
    }

    @Override
    public Postulant getByEmail(AuthenticatePostulantRequest request) {
        return null;
    }

    @Override
    public Postulant getByEmailAndPassword(AuthenticatePostulantRequest request) {
        return postulantRepository.findByEmailAndPassword(request.email,request.password)
                .orElseThrow(()->new ResourceNotFoundException("Email or password not found"));
    }

    /*@Override
    public Postulant Authentication(AuthenticatePostulantRequest request) {
        var user= postulantRepository.findByEmail(request.email);
        if(user==null || request.password!=user.get().getPassword()){
            throw new ResourceNotFoundException(ENTITY,"error");
        }
        var response=mapper.
    }*/
}
