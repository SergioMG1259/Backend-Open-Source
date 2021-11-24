package pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.domain.model.entity;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.domain.model.entity.Application;
import pe.edu.upc.Easyjob.easyJob.BoundedCompany.domain.model.entity.Company;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
//ESto es el modelo de los anuncion utilizados por las empresas

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "announcements")
public class Announcement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=50)
    private String title;

    @NotNull
    @Size(max=400)
    private String description;
    @NotNull
    private String requiredSpecialty;
    @NotNull
    private String requiredExperience;
    @NotNull
    private Long salary;
    @NotNull
    private String typeMoney;
    @NotNull
    private Boolean visible;
    @NotNull
    private String date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;

    @OneToMany
    private List<Application> applications;
}
