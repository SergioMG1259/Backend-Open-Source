package pe.edu.upc.Easyjob.easyJob.BoundedPostulant.resource;
import lombok.Getter;
import lombok.Setter;

/*Proyecto de un postulante*/
@Getter
@Setter
public class SpecialtyResource {
    private Long id;

    private String specialty;

    private String experience;
    private Long postulantId;
}
