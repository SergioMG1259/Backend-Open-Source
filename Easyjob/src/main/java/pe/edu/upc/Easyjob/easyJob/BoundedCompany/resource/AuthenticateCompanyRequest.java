package pe.edu.upc.Easyjob.easyJob.BoundedCompany.resource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticateCompanyRequest {
    public String email;


    public String password;
}
