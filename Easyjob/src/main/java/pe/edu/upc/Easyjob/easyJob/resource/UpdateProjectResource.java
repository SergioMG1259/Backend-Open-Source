package pe.edu.upc.Easyjob.easyJob.resource;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProjectResource {
    @NotNull
    @Size(max=50)
    private String title;

    @NotNull
    @Size(max=400)
    private String description;

    private String linktogithub;

    private String imgproject;
}
