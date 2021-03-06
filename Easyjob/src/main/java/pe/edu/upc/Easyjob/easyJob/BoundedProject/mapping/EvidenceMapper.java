package pe.edu.upc.Easyjob.easyJob.BoundedProject.mapping;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.domain.model.entity.Evidence;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.resource.CreateEvidenceResource;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.resource.EvidenceResource;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.resource.UpdateEvidenceResource;
import pe.edu.upc.Easyjob.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
public class EvidenceMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public EvidenceResource toResource(Evidence model) {
        return mapper.map(model, EvidenceResource.class);
    }
    public Page<EvidenceResource> modelListToPage(List<Evidence> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, EvidenceResource.class), pageable, modelList.size());
    }
    public Evidence toModel(CreateEvidenceResource resource){return mapper.map(resource,Evidence.class);}
    public Evidence toModel(UpdateEvidenceResource resource) {
        return mapper.map(resource, Evidence.class);
    }
}
