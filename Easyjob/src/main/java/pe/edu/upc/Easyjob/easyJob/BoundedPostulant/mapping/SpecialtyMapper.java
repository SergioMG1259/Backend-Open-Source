package pe.edu.upc.Easyjob.easyJob.BoundedPostulant.mapping;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.model.entity.Specialty;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.resource.CreateSpecialtyResource;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.resource.SpecialtyResource;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.resource.UpdateSpecialtyResource;
import pe.edu.upc.Easyjob.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
public class SpecialtyMapper implements Serializable{
    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public SpecialtyResource toResource(Specialty model) {
        return mapper.map(model, SpecialtyResource.class);
    }
    public Page<SpecialtyResource> modelListToPage(List<Specialty> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, SpecialtyResource.class), pageable, modelList.size());
    }
    public Specialty toModel(CreateSpecialtyResource resource){return mapper.map(resource,Specialty.class);}
    public Specialty toModel(UpdateSpecialtyResource resource) {
        return mapper.map(resource, Specialty.class);
    }
}
