package nugu.mountain.api.interfaces;

import nugu.mountain.api.application.service.NuguService;
import nugu.mountain.api.interfaces.dto.request.NuguRequest;
import nugu.mountain.api.interfaces.dto.response.NuguResponse;
import nugu.mountain.api.interfaces.support.InterfaceSupport;
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
        return nuguService.testFunc(InterfaceSupport.getParametersFromNuguRequest(nuguRequest));
    }

    @PostMapping("/info")
    public NuguResponse getMntInfoAction(@RequestBody NuguRequest nuguRequest) throws IOException {
        return nuguService.getMntInfoAction(InterfaceSupport.getParametersFromNuguRequest(nuguRequest));
    }

    @PostMapping("/course**")
    public NuguResponse getMntCourseAction(@RequestBody NuguRequest nuguRequest) throws IOException {
        return nuguService.getMntCourseAction(InterfaceSupport.getParametersFromNuguRequest(nuguRequest));
    }

    @PostMapping("/air**")
    public NuguResponse getMntAirAction(@RequestBody NuguRequest nuguRequest) throws IOException {
        return nuguService.getMntAirAction(InterfaceSupport.getParametersFromNuguRequest(nuguRequest));
    }

    @PostMapping("/weather**")
    public NuguResponse getMntWeatherAction(@RequestBody NuguRequest nuguRequest) throws IOException {
        return nuguService.getMntWeatherAction(InterfaceSupport.getParametersFromNuguRequest(nuguRequest));
    }

    @PostMapping("/fire**")
    public NuguResponse getMntFireAction(@RequestBody NuguRequest nuguRequest) throws IOException {
        return nuguService.getMntFireAction(InterfaceSupport.getParametersFromNuguRequest(nuguRequest));
    }

    @PostMapping("/tour**")
    public NuguResponse getMntTourInfoAction(@RequestBody NuguRequest nuguRequest) throws IOException {
        return nuguService.getMntTourInfoAction(InterfaceSupport.getParametersFromNuguRequest(nuguRequest));
    }

    @PostMapping("/transport**")
    public NuguResponse getMntTransportAction(@RequestBody NuguRequest nuguRequest) throws IOException {
        return nuguService.getMntTransportAction(InterfaceSupport.getParametersFromNuguRequest(nuguRequest));
    }

    @PostMapping("/height")
    public NuguResponse getMntHeightAction(@RequestBody NuguRequest nuguRequest) throws IOException {
        return nuguService.getMntHeightAction(InterfaceSupport.getParametersFromNuguRequest(nuguRequest));
    }

    @PostMapping("/reason**")
    public NuguResponse getMntReasonAction(@RequestBody NuguRequest nuguRequest) throws IOException {
        return nuguService.getMntReasonAction(InterfaceSupport.getParametersFromNuguRequest(nuguRequest));
    }

    @PostMapping("/overview**")
    public NuguResponse getMntOverviewAction(@RequestBody NuguRequest nuguRequest) throws IOException {
        return nuguService.getMntOverviewAction(InterfaceSupport.getParametersFromNuguRequest(nuguRequest));
    }

    @PostMapping("/condition**")
    public NuguResponse getMntClimbingCondition(@RequestBody NuguRequest nuguRequest) throws IOException {
        return nuguService.getMntClimbingCondition(InterfaceSupport.getParametersFromNuguRequest(nuguRequest));
    }


}
