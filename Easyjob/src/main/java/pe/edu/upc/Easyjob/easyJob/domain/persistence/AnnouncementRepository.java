package pe.edu.upc.Easyjob.easyJob.domain.persistence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.Easyjob.easyJob.domain.model.entity.Announcement;

import java.util.List;
import java.util.Optional;
@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    List<Announcement> findByCompanyId(Long companyId);
    Page<Announcement> findByCompanyId(Long companyId, Pageable pageable);
    Optional<Announcement> findByIdAndCompanyId(Long id, Long companyId);
}
