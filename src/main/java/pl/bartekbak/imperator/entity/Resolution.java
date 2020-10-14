package pl.bartekbak.imperator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
@Table(name = "resolution")
@AllArgsConstructor
public class Resolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resolution")
    private int id;

    @Column(name = "resolution_no")
    private String resolutionId;

    @Column(name = "resolution_date")
    private LocalDate date;

    @Column(name = "resolution_title")
    private String title;

    @Column(name = "resolution_registry")
    private String registryId;

    public Resolution() {
    }

    public Resolution(String resolutionId, LocalDate date, String title, String registryId) {
        this.resolutionId = resolutionId;
        this.date = date;
        this.title = title;
        this.registryId = registryId;
    }

    @Override
    public String toString() {
        return "Resolution{" +
                "id=" + id +
                ", resolutionId='" + resolutionId + '\'' +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", registryId='" + registryId + '\'' +
                '}';
    }
}
