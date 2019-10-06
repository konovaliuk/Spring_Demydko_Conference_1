package one.persistence.data;

import one.persistence.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.Optional;

/**
 * Used for access to data base
 */
public interface IReport {
    Page<Report> futureReports(Date date, Pageable pageable);
    Page<Report> pastReports(Date date, Pageable pageable);
    Page<Report> offeredReports(Pageable pageable);
    Optional<Report> getReportBuId(Long id);
    Report saveReport(Report report);
    void deleteReportById(Long id);
}
