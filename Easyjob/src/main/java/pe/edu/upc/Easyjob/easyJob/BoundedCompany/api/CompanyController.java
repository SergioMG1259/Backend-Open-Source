package pe.edu.upc.Easyjob.easyJob.BoundedCompany.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.Easyjob.easyJob.BoundedCompany.domain.service.CompanyService;
import pe.edu.upc.Easyjob.easyJob.BoundedCompany.mapping.CompanyMapper;
import pe.edu.upc.Easyjob.easyJob.BoundedCompany.resource.AuthenticateCompanyRequest;
import pe.edu.upc.Easyjob.easyJob.BoundedCompany.resource.CompanyResource;
import pe.edu.upc.Easyjob.easyJob.BoundedCompany.resource.CreateCompanyResource;
import pe.edu.upc.Easyjob.easyJob.BoundedCompany.resource.UpdateCompanyResource;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyMapper mapper;
    @GetMapping
    public Page<CompanyResource>getAllCompanies(Pageable pageable){
        return mapper.modelListToPage(companyService.getAll(), pageable);
    }
    @GetMapping("{companyId}")
    public CompanyResource getCompanyById(@PathVariable("companyId")Long companyId){
        return mapper.toResource(companyService.getById(companyId));
    }
    @PostMapping
    public CompanyResource createCompany(@RequestBody CreateCompanyResource request){
        return mapper.toResource(companyService.create(mapper.toModel(request)));
    }
    @PutMapping("{companyId}")
    public CompanyResource updateCompany(@PathVariable Long companyId, @RequestBody UpdateCompanyResource request) {
        return mapper.toResource(companyService.update(companyId, mapper.toModel(request)));
    }

    @DeleteMapping("{companyId}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long companyId) {
        return companyService.delete(companyId);
    }
    @PostMapping("auth/sign-in")
    public CompanyResource Authenticate(@RequestBody AuthenticateCompanyRequest request){
        return mapper.toResource(companyService.Authenticate((request)));
    }
}
