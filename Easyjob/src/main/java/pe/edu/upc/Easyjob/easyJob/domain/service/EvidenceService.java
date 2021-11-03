package pe.edu.upc.Easyjob.easyJob.domain.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.Easyjob.easyJob.domain.model.entity.Evidence;

import java.util.List;
public interface EvidenceService {
    List<Evidence> getAllByProjectId(Long projectId);
    Page<Evidence> getAllByProjectId(Long projectId, Pageable pageable);
    Evidence create(Long projectId, Evidence request);
    Evidence getByIdAndProjectId(Long projectId, Long evidenceId);
    Evidence update(Long projectId, Long evidenceId, Evidence request);
    ResponseEntity<?> delete(Long projectId, Long evidenceId);
}
