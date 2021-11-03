package pe.edu.upc.Easyjob.easyJob.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostulantResource {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String description;
    private String namegithub;
    private String imgpostulant;
}
