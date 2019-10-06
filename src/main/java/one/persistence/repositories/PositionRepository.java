package one.persistence.repositories;



import one.persistence.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
    Position findPositionByPosition(String position);
}
