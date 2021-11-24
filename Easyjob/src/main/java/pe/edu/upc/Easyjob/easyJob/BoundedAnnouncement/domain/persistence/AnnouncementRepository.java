package pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.domain.persistence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.domain.model.entity.Announcement;

import java.util.List;
import java.util.Optional;
@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    List<Announcement> findByCompanyId(Long companyId);
    Page<Announcement> findByCompanyId(Long companyId, Pageable pageable);
    List<Announcement> findByRequiredExperienceNotAndVisible(String practicing,Boolean visible);
    Page<Announcement> findByRequiredExperienceNotAndVisible(String practicing,Boolean visible,Pageable pageable);
    List<Announcement> findByRequiredExperienceAndVisible(String practicing,Boolean visible);
    Page<Announcement> findByRequiredExperienceAndVisible(String practicing,Boolean visible,Pageable pageable);
    Optional<Announcement> findById(Long id);
}
