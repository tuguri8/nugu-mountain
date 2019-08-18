package nugu.mountain.api.infrastructure.repository;

import nugu.mountain.api.domain.entity.Mountain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MountainRepository extends JpaRepository<Mountain, Long> {
    Optional<Mountain> findByMntName(String mntName);

    Optional<List<Mountain>> findAllByAreaCode(String areaCode);
}
