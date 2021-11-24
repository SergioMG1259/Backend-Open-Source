package pe.edu.upc.Easyjob.easyJob.BoundedPostulant.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateSpecialtyResource {
    @NotNull
    private String specialty;
    @NotNull
    private String experience;
}
