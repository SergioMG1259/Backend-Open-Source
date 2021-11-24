package pe.edu.upc.Easyjob.easyJob.BoundedProject.domain.model.entity;

import lombok.*;
import pe.edu.upc.Easyjob.shared.domain.model.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "evidences")
public class Evidence extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=50)
    private String titleEvidence;

    @Size(max=400)
    private String descriptionEvidence;

    private String imgEvidence;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "projectId", nullable = false)
    private Project project;
}
