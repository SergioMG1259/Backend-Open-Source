package pe.edu.upc.Easyjob.easyJob.BoundedCompany.domain.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.Easyjob.easyJob.BoundedCompany.domain.model.entity.Company;
import pe.edu.upc.Easyjob.easyJob.BoundedCompany.resource.AuthenticateCompanyRequest;

import java.util.List;
public interface CompanyService {
    List<Company>getAll();
    Page<Company> getAll(Pageable pageable);
    Company getById(Long companyId);
    Company create(Company company);
    Company update(Long companyId,Company request);
    ResponseEntity<?>delete(Long companyId);
    Company Authenticate(AuthenticateCompanyRequest request);
}
