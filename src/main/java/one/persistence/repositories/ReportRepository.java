package one.persistence.repositories;

import one.persistence.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report,Long> {
    Page<Report> findByDateGreaterThan(Date date, Pageable pageable);
    Page<Report> findByDateLessThan(Date date, Pageable pageable);
    Page<Report> findByDateIsNull(Pageable pageable);

    Page<Report> findByDateIsNullAndSpeakerNotNull(Pageable pageable);

    Optional<Report> findById(Long id);
}
