package pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.model.entity;

import lombok.*;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.domain.model.entity.Application;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.domain.model.entity.Project;
import pe.edu.upc.Easyjob.shared.domain.model.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/*Postulant CRUD*/

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "postulants")
public class Postulant extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=50)
    private String name;

    @NotNull
    @Size(max=50)
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    @Size(max=20)
    private String password;

    @NotNull
    @Size(max=600)
    private String description;
    @NotNull
    private String nameGithub;
    @NotNull
    private String imgPostulant;
    @OneToMany
    private List<Project> projects;
    @OneToMany
    private List<Specialty> specialties;
    @OneToMany
    private List<Application> applications;
}
