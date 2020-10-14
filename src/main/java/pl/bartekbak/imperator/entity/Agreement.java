package pl.bartekbak.imperator.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "agreement")
@AllArgsConstructor
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agreement")
    private int id;

    @Column(name = "agreement_date")
    private LocalDate agreementDate;

    @Column(name = "agreement_registry")
    private String AgreementRegistry;

    public Agreement() {
    }

    @Override
    public String toString() {
        return "Agreement{" +
                "id=" + id +
                ", agreementDate=" + agreementDate +
                ", AgreementRegistry='" + AgreementRegistry + '\'' +
                '}';
    }
}
