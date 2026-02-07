package edu.rutgers.rusafe.controller;

import edu.rutgers.rusafe.dto.ReportDto;
import edu.rutgers.rusafe.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private ReportService reportService;

    // Add Report REST API
    @PostMapping
    public ResponseEntity<ReportDto> createReport(@RequestBody ReportDto reportDto) {
        ReportDto savedReport = reportService.createReport(reportDto);
        return new ResponseEntity<>(savedReport, HttpStatus.CREATED);
    }

    // Get Report REST API
    @GetMapping("{id}")
    public ResponseEntity<ReportDto> getReportById(@PathVariable("id") Long reportId) {
        ReportDto reportDto = reportService.getReportById(reportId);
        return ResponseEntity.ok(reportDto);
    }

    // Get all Employees REST API
    @GetMapping
    public ResponseEntity<List<ReportDto>> getAllReports() {
        List<ReportDto> reports = reportService.getAllReports();
        return ResponseEntity.ok(reports);
    }

    // Update Report REST API
    @PutMapping("{id}")
    public ResponseEntity<ReportDto> updateReport(@PathVariable("id") Long reportId,
                                                  @RequestBody ReportDto updatedReport) {
        ReportDto reportDto = reportService.updateReport(reportId, updatedReport);
        return ResponseEntity.ok(reportDto);
    }

    // Delete Report REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteReport(@PathVariable("id") Long reportId) {
        reportService.deleteReport(reportId);
        return ResponseEntity.ok("Report " + reportId + " deleted successfully!");
    }


}
