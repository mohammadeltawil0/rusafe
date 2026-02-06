package edu.rutgers.rusafe.repository;

import edu.rutgers.rusafe.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
