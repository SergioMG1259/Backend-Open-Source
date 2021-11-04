package pe.edu.upc.Easyjob.easyJob.domain.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.Easyjob.easyJob.domain.model.entity.Announcement;

import java.util.List;
public interface AnnouncementService {
    List<Announcement> getAllByCompanyId(Long companyId);
    Page<Announcement> getAllByCompanyId(Long companyId, Pageable pageable);
    Announcement create(Long companyId, Announcement request);
    Announcement getByIdAndCompanyId(Long companyId, Long announcementId);
    Announcement update(Long companyId, Long announcementId, Announcement request);
    ResponseEntity<?> delete(Long companyId, Long announcementId);
}
