package pe.edu.upc.Easyjob.easyJob.BoundedCompany.domain.model.entity;

import lombok.*;
import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.domain.model.entity.Announcement;
import pe.edu.upc.Easyjob.shared.domain.model.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "companies")
public class Company extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=50)
    private String nameCompany;

    @NotNull
    private String email;

    @NotNull
    @Size(max=20)
    private String password;

    @NotNull
    @Size(max=600)
    private String descriptionCompany;

    @NotNull
    private String imgCompany;

    @OneToMany
    private List<Announcement> announcements;

}
