package pe.edu.upc.Easyjob.easyJob.resource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyResource {
    private Long id;
    private String namecompany;
    private String email;
    private String password;
    private String descriptioncompany;
    private String imgcompany;
}
