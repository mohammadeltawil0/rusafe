package edu.rutgers.rusafe.dto;

import edu.rutgers.rusafe.model.enums.ReportType;
import edu.rutgers.rusafe.model.enums.StatusType;
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
public class ReportDto {

    private Long id;
    private String title;
    private String caption;
    private Time timeCreated;
    private ReportType reportType;
    private StatusType status;
    private Boolean anonymous;
    private String imageURL;
    private Double latitude;
    private Double longitude;
}
