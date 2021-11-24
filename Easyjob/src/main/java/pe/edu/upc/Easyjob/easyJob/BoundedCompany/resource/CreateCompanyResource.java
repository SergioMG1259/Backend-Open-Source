package pe.edu.upc.Easyjob.easyJob.BoundedCompany.resource;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
public class CreateCompanyResource {
    @NotNull
    @Size(max=50)
    private String nameCompany;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    @Size(max=600)
    private String descriptionCompany;

    private String imgCompany;
}
