package pe.edu.upc.Easyjob.easyJob.BoundedNotification.api;
import pe.edu.upc.Easyjob.easyJob.BoundedNotification.domain.service.NotificationService;
import pe.edu.upc.Easyjob.easyJob.BoundedNotification.mapping.NotificationMapper;
import pe.edu.upc.Easyjob.easyJob.BoundedNotification.resource.CreateNotificationResource;
import pe.edu.upc.Easyjob.easyJob.BoundedNotification.resource.NotificationResource;
import pe.edu.upc.Easyjob.easyJob.BoundedNotification.resource.UpdateNotificationResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private NotificationMapper mapper;
    @GetMapping
    public Page<NotificationResource>getAllNotifications(Pageable pageable){
        return mapper.modelListToPage(notificationService.getAll(), pageable);
    }
    @GetMapping("/company/{companyId}")
    public Page<NotificationResource>getByCompanyId(@PathVariable("companyId")Long companyId,Pageable pageable){
        return mapper.modelListToPage(notificationService.getByCompanyIdAndType(companyId,"new-postulant"), pageable);
    }
    @GetMapping("/postulant/{postulantId}")
    public Page<NotificationResource>getByPostulantId(@PathVariable("postulantId")Long postulantId,Pageable pageable){
        return mapper.modelListToPage(notificationService.getByPostulantIdAndTypeNot(postulantId,"new-postulant"), pageable);
    }
    @GetMapping("{notificationId}")
    public NotificationResource getById(@PathVariable("notificationId") Long notificationId){
        return mapper.toResource(notificationService.getById(notificationId));
    }
    @PostMapping("company/{companyId}/announcement/{announcementId}/postulant/{postulantId}")
    public NotificationResource createNotification(@PathVariable("companyId")Long companyId,
                                                   @PathVariable("announcementId")Long announcementId,
                                                   @PathVariable("postulantId")Long postulantId,
                                                   @RequestBody CreateNotificationResource request){
        return mapper.toResource(notificationService.create(companyId,announcementId,postulantId, mapper.toModel(request)));
    }
    @PutMapping("{notificationId}")
    public NotificationResource updateNotification(@PathVariable Long notificationId,
                                                 @RequestBody UpdateNotificationResource request) {
        return mapper.toResource(notificationService.update(notificationId, mapper.toModel(request)));
    }
    @DeleteMapping("{notificationId}")
    public ResponseEntity<?> deleteNotification(@PathVariable Long notificationId) {
        return notificationService.delete(notificationId);
    }
}
