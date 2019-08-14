package nugu.mountain.api.infrastructure.repository;

import nugu.mountain.api.domain.entity.Air;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirRepository extends JpaRepository<Air, Long> {
}
