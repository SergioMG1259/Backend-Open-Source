package pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.domain.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.domain.model.entity.Announcement;

import java.util.List;
public interface AnnouncementService {
    List<Announcement>getAll();
    Page<Announcement> getAll(Pageable pageable);
    List<Announcement> getAllByCompanyId(Long companyId);
    Page<Announcement> getAllByCompanyId(Long companyId, Pageable pageable);
    List<Announcement> getNotPracticing(String practicing,Boolean visible);
    Page<Announcement> getNotPracticing(String practicing,Boolean visible,Pageable pageable);
    List<Announcement> getPracticing(String practicing,Boolean visible);
    Page<Announcement> getPracticing(String practicing,Boolean visible,Pageable pageable);
    Announcement create(Long companyId, Announcement request);
    Announcement getById(Long announcementId);
    Announcement update(Long announcementId, Announcement request);
    ResponseEntity<?> delete(Long announcementId);
}
