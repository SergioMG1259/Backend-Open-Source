package pe.edu.upc.Easyjob.easyJob.BoundedApplication.domain.persistence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.domain.model.entity.Application;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.model.entity.Postulant;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>{
    List<Application> findByAnnouncementId(Long announcementId);
    Page<Application> findByAnnouncementId(Long announcementId, Pageable pageable);
    List<Application> findByAnnouncementIdAndPostulantId(Long announcementId,Long postulantId);
    Page<Application> findByAnnouncementIdAndPostulantId(Long announcementId,Long postulantId, Pageable pageable);
    Optional<Postulant> findByPostulantId(Long id);
    //Optional<Application>findById(Long id);
}
