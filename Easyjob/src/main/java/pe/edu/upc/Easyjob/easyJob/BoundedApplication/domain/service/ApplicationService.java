package pe.edu.upc.Easyjob.easyJob.BoundedApplication.domain.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.domain.model.entity.Application;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.model.entity.Postulant;

import java.util.List;

public interface ApplicationService {
    List<Application>getAllApplications();
    Page<Application> getAllApplications(Pageable pageable);

    List<Application>getApplicationsByAnnouncementId(Long announcementId);
    Page<Application> getApplicationsByAnnouncementId(Long announcementId,Pageable pageable);

    List<Application>getApplicationsByAnnouncementIdAndPostulantId(Long announcementId,Long postulantId);
    Page<Application> getApplicationsByAnnouncementIdAndPostulantId(Long announcementId,Long postulantId,Pageable pageable);

    Postulant getByPostulantId(Long id);

    Application create(Long announcementId,Long postulantId, Application request);
    Application getById(Long applicationtId);
    Application update(Long applicationId, Application request);
    ResponseEntity<?> delete(Long applicationId);
}
