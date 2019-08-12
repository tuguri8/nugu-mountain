package nugu.mountain.api.interfaces;

import nugu.mountain.api.application.service.MountainService;
import nugu.mountain.api.infrastructure.mountain.MountainResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    private final MountainService mountainService;

    public SampleController(MountainService mountainService) {this.mountainService = mountainService;}

    @GetMapping("/api/test")
    public MountainResponse apiTest() {
        return mountainService.getMountain();
    }
}
