package pe.edu.upc.Easyjob.easyJob.BoundedProject.resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEvidenceResource {
    @NotNull
    @Size(max=50)
    private String titleEvidence;

    @Size(max=400)
    private String descriptionEvidence;

    private String imgEvidence;
}
