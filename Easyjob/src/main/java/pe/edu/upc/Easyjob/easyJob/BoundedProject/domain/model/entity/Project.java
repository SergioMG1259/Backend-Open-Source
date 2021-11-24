package pe.edu.upc.Easyjob.easyJob.BoundedProject.domain.model.entity;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.model.entity.Postulant;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "projects")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=50)
    private String title;

    @NotNull
    @Size(max=400)
    private String description;

    private String linkToGithub;

    private String imgProject;

    @OneToMany
    private List<Evidence> evidences;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "postulantId", nullable = false)
    private Postulant postulant;
}
