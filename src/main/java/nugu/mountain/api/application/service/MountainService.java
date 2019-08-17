package nugu.mountain.api.application.service;

import com.fasterxml.jackson.databind.JsonNode;
import nugu.mountain.api.domain.entity.Mountain;
import nugu.mountain.api.domain.entity.MountainFire;
import nugu.mountain.api.infrastructure.mountain.MountainResponse;

public interface MountainService {
    void getMountain();

    void geocoding();

    void syncMountainFire();

    MountainFire getMountainFireFromAreaCode(String areaCode);

    Mountain getMountainFromName(String mntName);
}
