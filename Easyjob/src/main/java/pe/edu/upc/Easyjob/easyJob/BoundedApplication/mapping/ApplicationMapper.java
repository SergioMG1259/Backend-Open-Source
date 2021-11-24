package pe.edu.upc.Easyjob.easyJob.BoundedApplication.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.domain.model.entity.Application;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.resource.ApplicationResource;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.resource.CreateApplicationResource;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.resource.UpdateApplicationResource;
import pe.edu.upc.Easyjob.shared.mapping.EnhancedModelMapper;

import java.util.List;

public class ApplicationMapper {
    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public ApplicationResource toResource(Application model) {
        return mapper.map(model, ApplicationResource.class);
    }
    public Page<ApplicationResource> modelListToPage(List<Application> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ApplicationResource.class), pageable, modelList.size());
    }
    public Application toModel(CreateApplicationResource resource){return mapper.map(resource,Application.class);}
    public Application toModel(UpdateApplicationResource resource) {
        return mapper.map(resource, Application.class);
    }
}
