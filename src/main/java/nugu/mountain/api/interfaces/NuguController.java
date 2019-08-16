package nugu.mountain.api.interfaces;

import nugu.mountain.api.application.service.NuguService;
import nugu.mountain.api.interfaces.dto.request.NuguRequest;
import nugu.mountain.api.interfaces.dto.response.NuguResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class NuguController {

    private final NuguService nuguService;

    public NuguController(NuguService nuguService) {this.nuguService = nuguService;}

    @PostMapping("/func")
    public NuguResponse testFunc(@RequestBody NuguRequest nuguRequest) throws IOException {
        return nuguService.testFunc(nuguRequest);
    }
}
