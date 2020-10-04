package pl.bartekbak.imperator.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
@Table(name = "resolution")
public class Resolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idResolution")
    private int id;

    @Column(name = "ResolutionNo")
    private String resolutionId;

    @Column(name = "ResolutionDate")
    private LocalDate date;

    @Column(name = "ResolutionTitle")
    private String title;

    @Column(name = "ResolutionRegistry")
    private String registryId;

    public Resolution() {
    }

    public Resolution(int id, String resolutionId, LocalDate date, String title, String registryId) {
        this.id = id;
        this.resolutionId = resolutionId;
        this.date = date;
        this.title = title;
        this.registryId = registryId;
    }

    public Resolution(String resolutionId, LocalDate date, String title, String registryId) {
        this.resolutionId = resolutionId;
        this.date = date;
        this.title = title;
        this.registryId = registryId;
    }
}
