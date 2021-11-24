package pe.edu.upc.Easyjob.easyJob.BoundedNotification.mapping;
import pe.edu.upc.Easyjob.easyJob.BoundedNotification.domain.model.entity.Notification;
import pe.edu.upc.Easyjob.easyJob.BoundedNotification.resource.NotificationResource;
import pe.edu.upc.Easyjob.easyJob.BoundedNotification.resource.CreateNotificationResource;
import pe.edu.upc.Easyjob.easyJob.BoundedNotification.resource.UpdateNotificationResource;
import pe.edu.upc.Easyjob.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
public class NotificationMapper {
    @Autowired
    EnhancedModelMapper mapper;
    public NotificationResource toResource(Notification model) {
        return mapper.map(model, NotificationResource.class);
    }
    public Page<NotificationResource> modelListToPage(List<Notification> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, NotificationResource.class), pageable, modelList.size());
    }
    public Notification toModel(CreateNotificationResource resource){return mapper.map(resource,Notification.class);}
    public Notification toModel(UpdateNotificationResource resource) {
        return mapper.map(resource, Notification.class);
    }
}
