package pe.edu.upc.Easyjob.easyJob.resource;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
public class CreateSpecialtyResource {
    @NotNull
    private String specialty;
    @NotNull
    private String experience;
}
