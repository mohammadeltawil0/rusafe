package edu.rutgers.rusafe.controller;

import edu.rutgers.rusafe.dto.ReportDto;
import edu.rutgers.rusafe.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
