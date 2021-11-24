package pe.edu.upc.Easyjob.easyJob.BoundedCompany.resource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyResource {
    private Long id;
    private String nameCompany;
    private String email;
    private String password;
    private String descriptionCompany;
    private String imgCompany;
}
