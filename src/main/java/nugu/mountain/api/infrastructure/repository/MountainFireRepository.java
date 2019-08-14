package nugu.mountain.api.infrastructure.repository;

import nugu.mountain.api.domain.entity.MountainFire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MountainFireRepository extends JpaRepository<MountainFire, Long> {
}
