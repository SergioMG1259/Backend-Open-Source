package pe.edu.upc.Easyjob.easyJob.resource;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSpecialtyResource {
    @NotNull
    private String specialty;
    @NotNull
    private String experience;
}
