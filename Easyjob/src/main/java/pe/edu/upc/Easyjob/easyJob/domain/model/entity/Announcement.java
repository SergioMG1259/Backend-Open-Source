package pe.edu.upc.Easyjob.easyJob.domain.model.entity;
import pe.edu.upc.Easyjob.shared.domain.model.AuditModel;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
//ESto es el modelo de los anuncion utilizados por las empresas

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "announcements")
public class Announcement extends AuditModel{
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
    private String requiredspecialty;
    @NotNull
    private String requiredexperience;
    @NotNull
    private Long salary;
    @NotNull
    private String typemoney;
    @NotNull
    private Boolean visible;
    @NotNull
    private String date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
