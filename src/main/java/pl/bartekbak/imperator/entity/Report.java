package pl.bartekbak.imperator.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "report")
@AllArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_report")
    private int id;

    @Column(name = "report_type")
    private String reportType;

    @Column(name = "report_due_date")
    private LocalDate reportDueDate;

    @Column(name = "report_date_send")
    private LocalDate reportDateSend;

    @Column(name = "report_link")
    private String reportLink;

    public Report() {
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", reportType='" + reportType + '\'' +
                ", reportDueDate=" + reportDueDate +
                ", reportDateSend=" + reportDateSend +
                ", reportLink='" + reportLink + '\'' +
                '}';
    }
}
