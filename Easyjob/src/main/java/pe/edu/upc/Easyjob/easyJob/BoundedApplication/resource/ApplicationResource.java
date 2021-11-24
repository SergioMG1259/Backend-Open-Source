package pe.edu.upc.Easyjob.easyJob.BoundedApplication.resource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationResource
{
    private Long id;

    private Long announcementId;

    private Long postulantId;

    private String status;
}
