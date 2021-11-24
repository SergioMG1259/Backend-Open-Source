package pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.model.entity.Postulant;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostulantRepository extends JpaRepository<Postulant, Long> {

    Optional<Postulant> findByEmail(String email);
    Optional<Postulant> findByEmailAndPassword(String email,String password);
}
