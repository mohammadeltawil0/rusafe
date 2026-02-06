package edu.rutgers.rusafe.model;

import edu.rutgers.rusafe.model.enums.ReportType;
import edu.rutgers.rusafe.model.enums.StatusType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.sql.Time;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @Column(nullable = false)
    private String title;

    @Column(length = 5000)
    private String caption;

    @Column(nullable = false)
    private Time timeCreated;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReportType reportType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusType status;

    private Boolean anonymous;

    private String imageURL;

    private Double latitude;
    private Double longitude;

}
