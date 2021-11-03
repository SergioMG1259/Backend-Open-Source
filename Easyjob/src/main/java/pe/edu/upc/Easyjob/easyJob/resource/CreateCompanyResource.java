package pe.edu.upc.Easyjob.easyJob.resource;
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
