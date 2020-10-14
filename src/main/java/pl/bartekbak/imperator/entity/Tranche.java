package pl.bartekbak.imperator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tranche")
@Getter @Setter
@AllArgsConstructor
public class Tranche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tranche")
    private int id;

    @Column(name = "capital_date")
    private LocalDate capitalDate;
    @Column(name = "donation_date")
    private LocalDate donationDate;
    @Column(name = "capital_amount")
    private double capitalAmount;
    @Column(name = "donation_amount")
    private double donationAmount;

    public Tranche() {
    }

    @Override
    public String toString() {
        return "Tranche{" +
                "id=" + id +
                ", capitalDate=" + capitalDate +
                ", donationDate=" + donationDate +
                ", capitalAmount=" + capitalAmount +
                ", donationAmount=" + donationAmount +
                '}';
    }
}
