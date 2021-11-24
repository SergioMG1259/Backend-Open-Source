package pe.edu.upc.Easyjob.easyJob.BoundedApplication.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateApplicationResource {
    @NotNull
    private String status;
}
