package nugu.mountain.api.infrastructure.airkorea;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "airkorea-client")
public interface AirkoreaClient {
    @GetMapping(value = "/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureLIst")
    AirkoreaResponse getAir(@RequestParam("serviceKey") String serviceKey,
                            @RequestParam("numOfRows") String numOfRows,
                            @RequestParam("pageNo") String pageNo,
                            @RequestParam("itemCode") String itemCode,
                            @RequestParam("dataGubun") String dataGubun,
                            @RequestParam("searchCondition") String searchCondition);
}
