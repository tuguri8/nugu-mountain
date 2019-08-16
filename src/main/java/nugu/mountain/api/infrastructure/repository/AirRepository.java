package nugu.mountain.api.infrastructure.repository;

import nugu.mountain.api.domain.entity.Air;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirRepository extends JpaRepository<Air, Long> {
    Optional<Air> findTopByAreaCodeOrderById(String areaCode);
}
