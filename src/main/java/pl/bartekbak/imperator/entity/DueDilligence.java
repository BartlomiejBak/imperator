package pl.bartekbak.imperator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "duedilligence")
@AllArgsConstructor
@Getter @Setter
public class DueDilligence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dd")
    private int id;

    @Column(name = "dd_type")
    private String ddType;

    @Column(name = "dd_date")
    private LocalDate ddDate;

    @Column(name = "dd_registry")
    private String ddRegistry;

    public DueDilligence() {
    }

    @Override
    public String toString() {
        return "DueDilligence{" +
                "id=" + id +
                ", ddType='" + ddType + '\'' +
                ", ddDate=" + ddDate +
                ", ddRegistry='" + ddRegistry + '\'' +
                '}';
    }
}
