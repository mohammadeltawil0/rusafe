package edu.rutgers.rusafe.mapper;

import edu.rutgers.rusafe.dto.ReportDto;
import edu.rutgers.rusafe.model.Report;

public class ReportMapper {

    public static ReportDto mapToReportDto(Report report) {
        return new ReportDto(
                report.getReportId(),
                report.getTitle(),
                report.getCaption(),
                report.getTimeCreated(),
                report.getReportType(),
                report.getStatus(),
                report.getAnonymous(),
                report.getImageURL(),
                report.getLatitude(),
                report.getLongitude()
        );
    }

    public static Report mapToReport(ReportDto reportDto) {
        return new Report(
                reportDto.getReportId(),
                reportDto.getTitle(),
                reportDto.getCaption(),
                reportDto.getTimeCreated(),
                reportDto.getReportType(),
                reportDto.getStatus(),
                reportDto.getAnonymous(),
                reportDto.getImageURL(),
                reportDto.getLatitude(),
                reportDto.getLongitude()
        );
    }
}
