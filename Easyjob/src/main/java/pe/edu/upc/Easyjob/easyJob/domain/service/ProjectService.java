package pe.edu.upc.Easyjob.easyJob.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.Easyjob.easyJob.domain.model.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project>getAll();
    Page<Project> getAll(Pageable pageable);
    List<Project> getAllByPostulantId(Long postulantId);
    Page<Project> getAllByPostulantId(Long postulantId, Pageable pageable);
    Project create(Long postulantId, Project request);
    Project getByIdAndPostulantId(Long postulantId, Long projectId);
    Project update(Long postulantId, Long projectId, Project request);
    ResponseEntity<?> delete(Long postulantId, Long projectId);
}
