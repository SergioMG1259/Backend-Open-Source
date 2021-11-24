package pe.edu.upc.Easyjob.easyJob.BoundedPostulant.resource;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
public class AuthenticatePostulantRequest {

    public String email;


    public String password;
}
