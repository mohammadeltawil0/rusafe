package edu.rutgers.rusafe.service.impl;

import edu.rutgers.rusafe.dto.ReportDto;
import edu.rutgers.rusafe.exception.ResourceNotFoundException;
import edu.rutgers.rusafe.mapper.ReportMapper;
import edu.rutgers.rusafe.model.Report;
import edu.rutgers.rusafe.repository.ReportRepository;
import edu.rutgers.rusafe.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    private ReportRepository reportRepository;

    @Override
    public ReportDto createReport(ReportDto reportDto) {
        Report report = ReportMapper.mapToReport(reportDto);
        Report savedReport = reportRepository.save(report);
        return ReportMapper.mapToReportDto(savedReport);
    }

    @Override
    public ReportDto getReportById(Long reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() ->  new ResourceNotFoundException("Report with ID = " + reportId + " NOT FOUND!"));
        return ReportMapper.mapToReportDto(report);
    }

    @Override
    public List<ReportDto> getAllReports() {
        List<Report> reports = reportRepository.findAll();
        return reports.stream().map((report) -> ReportMapper.mapToReportDto(report))
                .collect(Collectors.toList());
    }

    @Override
    public ReportDto updateReport(Long reportId, ReportDto updatedReport) {
        Report report = reportRepository.findById(reportId).orElseThrow(
                () -> new ResourceNotFoundException("Report with ID = " + reportId + " NOT FOUND!")
        );

        report.setTitle(updatedReport.getTitle());
        report.setCaption(updatedReport.getCaption());
        report.setTimeCreated(updatedReport.getTimeCreated());
        report.setReportType(updatedReport.getReportType());
        report.setStatus(updatedReport.getStatus());
        report.setAnonymous(updatedReport.getAnonymous());
        report.setImageURL(updatedReport.getImageURL());
        report.setLatitude(updatedReport.getLatitude());
        report.setLongitude(updatedReport.getLongitude());

        Report updatedReportObj = reportRepository.save(report);
        return ReportMapper.mapToReportDto(updatedReportObj);
    }

    @Override
    public void deleteReport(Long reportId) {
        Report report = reportRepository.findById(reportId).orElseThrow(
                () -> new ResourceNotFoundException("Report with ID = " + reportId + " NOT FOUND!")
        );

        reportRepository.deleteById(reportId);
    }
}
