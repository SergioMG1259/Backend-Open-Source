package pe.edu.upc.Easyjob.easyJob.BoundedProject.domain.persistence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.domain.model.entity.Project;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectResporitory extends JpaRepository<Project, Long> {
    List<Project> findByPostulantId(Long postulantId);
    Page<Project> findByPostulantId(Long postulantId, Pageable pageable);
    Optional<Project> findById(Long id);
}
