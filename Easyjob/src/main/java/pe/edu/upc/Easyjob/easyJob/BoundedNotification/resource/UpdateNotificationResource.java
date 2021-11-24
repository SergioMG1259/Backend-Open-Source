package pe.edu.upc.Easyjob.easyJob.BoundedNotification.resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateNotificationResource {

    @NotNull
    private String type;

}
