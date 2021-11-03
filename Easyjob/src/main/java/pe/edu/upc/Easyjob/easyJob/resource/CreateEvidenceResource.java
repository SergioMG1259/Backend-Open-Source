package pe.edu.upc.Easyjob.easyJob.resource;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
public class CreateEvidenceResource {
    @NotNull
    @Size(max=50)
    private String titleevidence;

    @Size(max=400)
    private String descriptionevidence;

    private String imgevidence;
}
