package pe.edu.upc.Easyjob.easyJob.BoundedApplication.resource;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateApplicationResource {
    @NotNull
    private String status;
}
