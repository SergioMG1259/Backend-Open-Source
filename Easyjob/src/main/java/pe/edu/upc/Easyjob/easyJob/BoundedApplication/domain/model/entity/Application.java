package pe.edu.upc.Easyjob.easyJob.BoundedApplication.domain.model.entity;

import lombok.*;
import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.domain.model.entity.Announcement;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.model.entity.Postulant;
import pe.edu.upc.Easyjob.shared.domain.model.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "applications")
public class Application extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "announcementId", nullable = false)
    private Announcement announcement;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "postulantId", nullable = false)
    private Postulant postulant;
    @NotNull
    private String status;
}
