package pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAnnouncementResource {
    @NotNull
    @Size(max=50)
    private String title;

    @NotNull
    @Size(max=400)
    private String description;

    @NotNull
    private String requiredSpecialty;

    @NotNull
    private String requiredExperience;

    private Long salary;

    @NotNull
    private String typeMoney;

    @NotNull
    private Boolean visible;
}
