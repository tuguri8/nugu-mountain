package nugu.mountain.api.infrastructure.repository;

import nugu.mountain.api.domain.entity.Mountain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MountainRepository extends JpaRepository<Mountain, Long> {

}
