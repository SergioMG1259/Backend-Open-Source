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
public class CreatePostulantResource {
    @NotNull
    @Size(max=50)
    private String name;

    @NotNull
    @Size(max=50)
    private String lastname;

    @NotNull
    private String email;

    @NotNull
    @Size(max=20)
    private String password;

    @NotNull
    @Size(max=600)
    private String description;
    @NotNull
    private String namegithub;
    @NotNull
    private String imgpostulant;
}
