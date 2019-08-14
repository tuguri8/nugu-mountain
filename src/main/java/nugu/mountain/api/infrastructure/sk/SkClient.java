package nugu.mountain.api.infrastructure.sk;

import nugu.mountain.api.infrastructure.sk.dto.GeocodingResponse;
import nugu.mountain.api.infrastructure.sk.dto.WeatherSummaryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sk-client")
public interface SkClient {
    @GetMapping(value = "/tmap/geo/fullAddrGeo")
    GeocodingResponse geocoding(@RequestParam("appKey") String appKey,
                                @RequestParam("version") String version,
                                @RequestParam("fullAddr") String fullAddr);

    @GetMapping(value = "/weather/summary")
    WeatherSummaryResponse getWeatherSummary(@RequestParam("appKey") String appKey,
                                             @RequestParam("version") String version,
                                             @RequestParam("lat") String lat,
                                             @RequestParam("lon") String lon);
}
