package pe.edu.upc.Easyjob.easyJob.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.mapping.AnnouncementMapper;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.mapping.ApplicationMapper;
import pe.edu.upc.Easyjob.easyJob.BoundedCompany.mapping.CompanyMapper;
import pe.edu.upc.Easyjob.easyJob.BoundedNotification.mapping.NotificationMapper;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.mapping.PostulantMapper;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.mapping.SpecialtyMapper;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.mapping.EvidenceMapper;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.mapping.ProjectMapper;
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
    @Bean
    public AnnouncementMapper announcementMapper(){return new AnnouncementMapper();}
    @Bean
    public SpecialtyMapper specialtyMapper(){return new SpecialtyMapper();}
    @Bean
    public ApplicationMapper applicationMapper(){return new ApplicationMapper();}
    @Bean
    public NotificationMapper notificationMapper(){return new NotificationMapper();}
}
