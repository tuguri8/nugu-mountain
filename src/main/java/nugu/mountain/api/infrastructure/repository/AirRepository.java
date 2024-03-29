package nugu.mountain.api.infrastructure.repository;

import nugu.mountain.api.domain.entity.Air;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AirRepository extends JpaRepository<Air, Long> {
    Optional<Air> findTopByAreaCodeOrderByIdDesc(String areaCode);

    Optional<List<Air>> findTop17ByOrderByIdDesc();
}
