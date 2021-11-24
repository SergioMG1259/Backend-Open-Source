package pe.edu.upc.Easyjob.easyJob.BoundedProject.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateProjectResource {
    @NotNull
    @Size(max=50)
    private String title;

    @NotNull
    @Size(max=400)
    private String description;

    private String linkToGithub;

    private String imgProject;
}
