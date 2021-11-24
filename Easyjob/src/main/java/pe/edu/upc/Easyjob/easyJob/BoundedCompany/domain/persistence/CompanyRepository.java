package pe.edu.upc.Easyjob.easyJob.BoundedCompany.domain.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.Easyjob.easyJob.BoundedCompany.domain.model.entity.Company;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{
    Optional<Company> findByEmailAndPassword(String email,String password);
}
