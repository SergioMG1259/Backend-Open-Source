package pe.edu.upc.Easyjob.easyJob.BoundedCompany.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateCompanyResource {
    @NotNull
    @Size(max=50)
    private String nameCompany;

    @NotNull
    private String email;

    @NotNull
    @Size(max=20)
    private String password;

    @NotNull
    @Size(max=600)
    private String descriptionCompany;

    private String imgCompany;
}
