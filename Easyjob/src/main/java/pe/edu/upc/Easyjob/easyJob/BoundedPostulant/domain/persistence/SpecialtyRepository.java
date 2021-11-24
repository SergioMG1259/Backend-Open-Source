package pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.persistence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.model.entity.Specialty;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
    List<Specialty> findByPostulantId(Long postulantId);
    Page<Specialty> findByPostulantId(Long postulantId, Pageable pageable);
    Optional<Specialty> findById(Long id);

    List<Specialty>findBySpecialtyOrExperience(String specialty,String experience);
    Page<Specialty>findBySpecialtyOrExperience(String specialty,String experience,Pageable pageable);
}
