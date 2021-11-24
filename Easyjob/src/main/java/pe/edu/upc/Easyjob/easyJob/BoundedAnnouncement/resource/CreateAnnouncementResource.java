package pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.resource;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
public class CreateAnnouncementResource {
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
    @NotNull
    private String date;
}
