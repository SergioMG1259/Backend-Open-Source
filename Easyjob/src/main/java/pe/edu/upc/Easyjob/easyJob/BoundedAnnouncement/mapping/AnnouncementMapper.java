package pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.mapping;
import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.domain.model.entity.Announcement;
import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.resource.AnnouncementResource;
import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.resource.CreateAnnouncementResource;
import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.resource.UpdateAnnouncementResource;
import pe.edu.upc.Easyjob.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

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
