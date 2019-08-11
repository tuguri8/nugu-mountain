package nugu.mountain.api.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/api/test")
    public String apiTest() {
        return "test";
    }
}
