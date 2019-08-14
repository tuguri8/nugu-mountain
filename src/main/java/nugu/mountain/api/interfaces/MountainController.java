package nugu.mountain.api.interfaces;

import nugu.mountain.api.application.service.MountainService;
import nugu.mountain.api.infrastructure.mountain.MountainResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MountainController {
    private final MountainService mountainService;

    public MountainController(MountainService mountainService) {this.mountainService = mountainService;}

    @GetMapping("/api/info")
    public void getMountain() {
        mountainService.getMountain();
    }

    @GetMapping("/api/geo")
    public void geocoding() {
        mountainService.geocoding();
    }
}
