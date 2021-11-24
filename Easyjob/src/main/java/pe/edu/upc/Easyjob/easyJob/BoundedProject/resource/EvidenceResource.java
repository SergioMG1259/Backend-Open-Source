package pe.edu.upc.Easyjob.easyJob.BoundedProject.resource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EvidenceResource {

    private Long id;

    private String titleEvidence;

    private String descriptionEvidence;

    private String imgEvidence;
    private Long projectId;

}
