package nugu.mountain.api.infrastructure.mountain;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mountain-client")
public interface MountainClient {
    @GetMapping(value = "/openapi/service/cultureInfoService/gdTrailInfoOpenAPI", headers = "Accept=application/xml")
    MountainResponse getMountain(@RequestParam("serviceKey") String serviceKey,
                                 @RequestParam("searchMtNm") String searchMtNm,
                                 @RequestParam("pageNo") String pageNo,
                                 @RequestParam("numOfRows") String numOfRows);
}
