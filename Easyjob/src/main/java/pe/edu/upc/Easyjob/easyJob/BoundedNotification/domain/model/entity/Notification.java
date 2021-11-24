package pe.edu.upc.Easyjob.easyJob.BoundedNotification.domain.model.entity;
import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.domain.model.entity.Announcement;
import pe.edu.upc.Easyjob.easyJob.BoundedCompany.domain.model.entity.Company;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.model.entity.Postulant;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "notifications")
public class Notification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String titleAnnouncement;

    @NotNull
    private String type;

    @NotNull
    private String feedback;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "announcementId", nullable = false)
    private Announcement announcement;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "postulantId", nullable = false)
    private Postulant postulant;
}
