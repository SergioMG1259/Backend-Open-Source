package pe.edu.upc.Easyjob.easyJob.domain.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.Easyjob.easyJob.domain.model.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{
}
