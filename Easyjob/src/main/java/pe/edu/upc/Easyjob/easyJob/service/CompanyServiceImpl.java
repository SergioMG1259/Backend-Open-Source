package pe.edu.upc.Easyjob.easyJob.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.Easyjob.easyJob.domain.model.entity.Company;
import pe.edu.upc.Easyjob.easyJob.domain.persistence.CompanyRepository;
import pe.edu.upc.Easyjob.easyJob.domain.service.CompanyService;
import pe.edu.upc.Easyjob.shared.exception.ResourceNotFoundException;
import pe.edu.upc.Easyjob.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
@Service
public class CompanyServiceImpl implements CompanyService{
    private static final String ENTITY = "Company";

    private final CompanyRepository companyRepository;

    private final Validator validator;

    public CompanyServiceImpl(CompanyRepository companyRepository, Validator validator) {
        this.companyRepository = companyRepository;
        this.validator = validator;
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Page<Company> getAll(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    @Override
    public Company getById(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,companyId));
    }

    @Override
    public Company create(Company company) {
        Set<ConstraintViolation<Company>>violations=validator.validate(company);
        if (!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY,violations);
        }
        return companyRepository.save(company);
    }

    @Override
    public Company update(Long companyId, Company request) {
        Set<ConstraintViolation<Company>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return companyRepository.findById(companyId).map(company ->
                companyRepository.save(
                        company.withNamecompany(request.getNamecompany())
                                .withDescriptioncompany(request.getDescriptioncompany())
                                .withImgcompany(request.getImgcompany()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, companyId));
    }

    @Override
    public ResponseEntity<?> delete(Long companyId) {
        return companyRepository.findById(companyId).map(company -> {
            companyRepository.delete(company);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, companyId));
    }
}

