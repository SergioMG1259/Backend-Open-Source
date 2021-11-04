package pe.edu.upc.Easyjob.easyJob.resource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnnouncementResource {
    private Long id;

    private String title;

    private String description;

    private String requiredspecialty;

    private String requiredexperience;

    private Long salary;

    private String typemoney;

    private Boolean visible;

    private String date;
}
