package pe.edu.upc.Easyjob.easyJob.BoundedCompany.mapping;
import pe.edu.upc.Easyjob.easyJob.BoundedCompany.domain.model.entity.Company;
import pe.edu.upc.Easyjob.easyJob.BoundedCompany.resource.CompanyResource;
import pe.edu.upc.Easyjob.easyJob.BoundedCompany.resource.CreateCompanyResource;
import pe.edu.upc.Easyjob.easyJob.BoundedCompany.resource.UpdateCompanyResource;
import pe.edu.upc.Easyjob.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
public class CompanyMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public CompanyResource toResource(Company model) {
        return mapper.map(model, CompanyResource.class);
    }
    public Page<CompanyResource> modelListToPage(List<Company> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, CompanyResource.class), pageable, modelList.size());
    }
    public Company toModel(CreateCompanyResource resource){return mapper.map(resource,Company.class);}
    public Company toModel(UpdateCompanyResource resource){return mapper.map(resource,Company.class);}
}
