package pe.edu.upc.Easyjob.easyJob.BoundedNotification.resource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationResource {
    private Long id;

    private String titleAnnouncement;

    private String type;

    private String feedback;

    private Long companyId;

    private Long AnnouncementId;

    private Long postulantId;
}
