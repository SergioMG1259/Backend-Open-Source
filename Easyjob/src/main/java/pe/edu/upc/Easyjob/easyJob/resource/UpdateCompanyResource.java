package pe.edu.upc.Easyjob.easyJob.resource;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCompanyResource {
    @NotNull
    @Size(max=50)
    private String namecompany;

    @NotNull
    private String email;

    @NotNull
    @Size(max=20)
    private String password;

    @NotNull
    @Size(max=600)
    private String descriptioncompany;

    private String imgcompany;
}
