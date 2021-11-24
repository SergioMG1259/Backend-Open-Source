package pe.edu.upc.Easyjob.easyJob.BoundedNotification.domain.persistence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.Easyjob.easyJob.BoundedNotification.domain.model.entity.Notification;

import java.util.List;
import java.util.Optional;
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByCompanyIdAndType(Long companyId,String type);
    Page<Notification> findByCompanyIdAndType(Long companyId,String type, Pageable pageable);

    List<Notification> findByPostulantIdAndTypeNot(Long companyId,String type);
    Page<Notification> findByPostulantIdAndTypeNot(Long companyId,String type,Pageable pageable);
}
