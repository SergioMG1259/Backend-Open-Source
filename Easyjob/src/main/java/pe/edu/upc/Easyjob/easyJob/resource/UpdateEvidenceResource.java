package pe.edu.upc.Easyjob.easyJob.resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEvidenceResource {
    @NotNull
    @Size(max=50)
    private String titleevidence;

    @Size(max=400)
    private String descriptionevidence;

    private String imgevidence;
}
