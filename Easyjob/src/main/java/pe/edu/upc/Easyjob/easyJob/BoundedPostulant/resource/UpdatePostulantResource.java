package pe.edu.upc.Easyjob.easyJob.BoundedPostulant.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdatePostulantResource {

    @NotNull
    @Size(max=50)
    private String name;

    @NotNull
    @Size(max=50)
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    @Size(max=20)
    private String password;

    @NotNull
    @Size(max=600)
    private String description;
    @NotNull
    private String nameGithub;
    @NotNull
    private String imgPostulant;
}
