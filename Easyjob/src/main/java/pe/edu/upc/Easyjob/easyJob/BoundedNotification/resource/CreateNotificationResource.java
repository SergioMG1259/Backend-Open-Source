package pe.edu.upc.Easyjob.easyJob.BoundedNotification.resource;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
public class CreateNotificationResource {
    @NotNull
    private String titleAnnouncement;

    @NotNull
    private String type;

    @NotNull
    private String feedback;
}
