package pe.edu.upc.Easyjob.easyJob.domain.persistence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.Easyjob.easyJob.domain.model.entity.Evidence;

import java.util.List;
import java.util.Optional;
@Repository
public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
    List<Evidence> findByProjectId(Long projectId);
    Page<Evidence> findByProjectId(Long projectId, Pageable pageable);
    Optional<Evidence> findByIdAndProjectId(Long id, Long projectId);
}
