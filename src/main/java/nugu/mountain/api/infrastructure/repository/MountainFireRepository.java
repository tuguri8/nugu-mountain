package nugu.mountain.api.infrastructure.repository;

import nugu.mountain.api.domain.entity.MountainFire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MountainFireRepository extends JpaRepository<MountainFire, Long> {
    Optional<MountainFire> findTopByAreaCodeOrderByIdDesc(String areaCode);
}
