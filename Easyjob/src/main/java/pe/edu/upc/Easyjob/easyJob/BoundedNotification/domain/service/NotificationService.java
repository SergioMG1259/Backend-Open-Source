package pe.edu.upc.Easyjob.easyJob.BoundedNotification.domain.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.Easyjob.easyJob.BoundedNotification.domain.model.entity.Notification;

import java.util.List;
public interface NotificationService {
    List<Notification>getAll();
    Page<Notification> getAll(Pageable pageable);

    List<Notification>getByCompanyIdAndType(Long companyId,String type);
    Page<Notification> getByCompanyIdAndType(Long companyId,String type,Pageable pageable);

    List<Notification>getByPostulantIdAndTypeNot(Long postulantId,String type);
    Page<Notification> getByPostulantIdAndTypeNot(Long postulantId,String type,Pageable pageable);

    Notification create(Long companyId,Long announcementId,Long postulantId, Notification request);
    Notification getById(Long notificationId);
    Notification update(Long notificationId, Notification request);
    ResponseEntity<?> delete(Long notificationId);
}
