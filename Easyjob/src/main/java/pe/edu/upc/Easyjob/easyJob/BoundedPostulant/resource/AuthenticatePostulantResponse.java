package pe.edu.upc.Easyjob.easyJob.BoundedPostulant.resource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticatePostulantResponse {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String description;
    private String nameGithub;
    private String imgPostulant;
}
