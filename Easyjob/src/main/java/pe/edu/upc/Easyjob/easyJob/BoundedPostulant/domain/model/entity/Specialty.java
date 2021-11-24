package pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.model.entity;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.model.entity.Postulant;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*Especialidad y la experiencia que tiene un postulante*/
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "specialties")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String specialty;

    @NotNull
    private String experience;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "postulantId", nullable = false)
    private Postulant postulant;
}
