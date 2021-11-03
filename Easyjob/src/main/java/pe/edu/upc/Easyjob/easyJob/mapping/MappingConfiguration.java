package pe.edu.upc.Easyjob.easyJob.mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("easyJobMappingConfiguration")

public class MappingConfiguration {
    @Bean
    public PostulantMapper postulantMapper(){return new PostulantMapper();}
    @Bean
    public ProjectMapper projectMapper(){return new ProjectMapper();}
    @Bean
    public EvidenceMapper evidenceMapper(){return new EvidenceMapper();}
    @Bean
    public CompanyMapper companyMapper(){return new CompanyMapper();}
}
