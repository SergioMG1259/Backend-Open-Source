package pe.edu.upc.Easyjob.easyJob.mapping;
import pe.edu.upc.Easyjob.easyJob.domain.model.entity.Announcement;
import pe.edu.upc.Easyjob.easyJob.resource.*;
import pe.edu.upc.Easyjob.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
public class AnnouncementMapper {
    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public AnnouncementResource toResource(Announcement model) {
        return mapper.map(model, AnnouncementResource.class);
    }
    public Page<AnnouncementResource> modelListToPage(List<Announcement> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, AnnouncementResource.class), pageable, modelList.size());
    }
    public Announcement toModel(CreateAnnouncementResource resource){return mapper.map(resource,Announcement.class);}
    public Announcement toModel(UpdateAnnouncementResource resource) {
        return mapper.map(resource, Announcement.class);
    }
}
