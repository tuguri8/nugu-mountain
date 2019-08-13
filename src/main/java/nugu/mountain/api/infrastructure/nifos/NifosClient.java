package nugu.mountain.api.infrastructure.nifos;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "nifos-client")
public interface NifosClient {
    @GetMapping(value = "/openapi/forestPoint/forestPointListSearch.do")
    NifosMountainFireResponse getMountainFireRate(@RequestParam("keyValue") String keyValue,
                                                  @RequestParam("localArea") String localArea,
                                                  @RequestParam("gubun") String gubun,
                                                  @RequestParam("version") String version,
                                                  @RequestParam("excludeForecast") String excludeForecast);
}