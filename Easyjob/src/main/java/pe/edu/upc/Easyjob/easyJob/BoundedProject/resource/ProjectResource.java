package pe.edu.upc.Easyjob.easyJob.BoundedProject.resource;

import lombok.Getter;
import lombok.Setter;
/*Proyecto de un postulante*/
@Getter
@Setter
public class ProjectResource {

    private Long id;

    private String title;

    private String description;

    private String linkToGithub;

    private String imgProject;
    private Long postulantId;

}
