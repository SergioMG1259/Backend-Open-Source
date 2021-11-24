package pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.resource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnnouncementResource {
    private Long id;

    private String title;

    private String description;

    private String requiredSpecialty;

    private String requiredExperience;

    private Long salary;

    private String typeMoney;

    private Boolean visible;

    private String date;
    private Long CompanyId;
}
