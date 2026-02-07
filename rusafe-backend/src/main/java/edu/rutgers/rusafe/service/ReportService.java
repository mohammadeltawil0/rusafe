package edu.rutgers.rusafe.service;

import edu.rutgers.rusafe.dto.ReportDto;

import java.util.List;

public interface ReportService {
    ReportDto createReport(ReportDto reportDto);
    ReportDto getReportById(Long reportId);
    List<ReportDto> getAllReports();
    ReportDto updateReport(Long reportId, ReportDto reportDto);
    void deleteReport(Long reportId);
}
