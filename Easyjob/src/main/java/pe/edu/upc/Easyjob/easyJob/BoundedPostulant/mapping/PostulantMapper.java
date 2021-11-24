package pe.edu.upc.Easyjob.easyJob.BoundedPostulant.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.model.entity.Postulant;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.resource.CreatePostulantResource;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.resource.PostulantResource;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.resource.UpdatePostulantResource;
import pe.edu.upc.Easyjob.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class PostulantMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public PostulantResource toResource(Postulant model) {
        return mapper.map(model, PostulantResource.class);
    }
    public Page<PostulantResource> modelListToPage(List<Postulant> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PostulantResource.class), pageable, modelList.size());
    }
    public Postulant toModel(CreatePostulantResource resource){return mapper.map(resource,Postulant.class);}
    public Postulant toModel(UpdatePostulantResource resource){return mapper.map(resource,Postulant.class);}
}
