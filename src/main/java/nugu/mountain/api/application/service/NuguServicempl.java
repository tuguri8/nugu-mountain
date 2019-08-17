package nugu.mountain.api.application.service;

import com.fasterxml.jackson.databind.JsonNode;
import nugu.mountain.api.domain.entity.Air;
import nugu.mountain.api.domain.entity.Mountain;
import nugu.mountain.api.domain.entity.MountainFire;
import nugu.mountain.api.infrastructure.repository.MountainFireRepository;
import nugu.mountain.api.infrastructure.repository.MountainRepository;
import nugu.mountain.api.infrastructure.sk.SkClient;
import nugu.mountain.api.infrastructure.sk.dto.WeatherSummaryResponse;
import nugu.mountain.api.interfaces.dto.response.NuguResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class NuguServicempl implements NuguService {

    private final WeatherService weatherService;
    private final MountainService mountainService;

    private static final Logger log = LoggerFactory.getLogger(NuguServicempl.class);

    public NuguServicempl(WeatherService weatherService,
                          MountainService mountainService) {
        this.weatherService = weatherService;
        this.mountainService = mountainService;
    }

    @Override
    public NuguResponse testFunc(JsonNode parameters) {
        String result = parameters.get("name").get("value").asText();
        log.info(result);
        Map<String, String> map = new HashMap<String, String>();
        map.put("resultName", result);
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntInfoAction(JsonNode parameters) {
        Mountain mountain = mountainService.getMountainFromName(parameters.get("mountain").get("value").asText());
        Map<String, String> map = new HashMap<String, String>();
        map.put("resultSubName", mountain.getSubName());
        map.put("resultMntName", mountain.getMntName());
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntCourseAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = mountainService.getMountainFromName(parametersFromNuguRequest.get("mountain").get("value").asText());
        Map<String, String> map = new HashMap<String, String>();
        String mntCourse = mountain.getEtcCourse();
        map.put("resultCourse", mntCourse);
        map.put("resultCourseDirect", mntCourse);
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntAirAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = mountainService.getMountainFromName(parametersFromNuguRequest.get("mountain").get("value").asText());
        Air air = weatherService.getAirFromAreaCode(mountain.getAreaCode());
        Map<String, String> map = new HashMap<String, String>();
        String airValue = air.getAirValue().toString();
        String airGrade = weatherService.getAirGradeFromValue(air.getAirValue());
        String airDate = air.getDataTime().format(DateTimeFormatter.ofPattern("M월dd일 H시"));
        map.put("resultAirValue", airValue);
        map.put("resultAirGrade", airGrade);
        map.put("resultAirDate", airDate);
        map.put("resultAirValueDirect", airValue);
        map.put("resultAirGradeDirect", airGrade);
        map.put("resultAirDateDirect", airDate);
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntWeatherAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = mountainService.getMountainFromName(parametersFromNuguRequest.get("mountain").get("value").asText());
        WeatherSummaryResponse.Summary summary = weatherService.getWeatherSummary(mountain.getLat(), mountain.getLon());

        Map<String, String> map = new HashMap<String, String>();
        String weatherText = String.format("%s의 일기예보를 알려드릴게요!, 오늘의 기상은 %s, 최고기온은 %s, 최저기온은 %s 입니다. 내일의 기상은 %s, 최고기온은 %s, 최저기온은 %s 입니다.",
                                           mountain.getMntName(),
                                           summary.getToday().getSky().getName(),
                                           summary.getToday().getTemperature().getTmax() + "도",
                                           summary.getToday().getTemperature().getTmin() + "도",
                                           summary.getTomorrow().getSky().getName(),
                                           summary.getTomorrow().getTemperature().getTmax() + "도",
                                           summary.getTomorrow().getTemperature().getTmin() + "도");
        map.put("resultWeatherText", weatherText);
        map.put("resultWeatherTextDirect", weatherText);
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntFireAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = mountainService.getMountainFromName(parametersFromNuguRequest.get("mountain").get("value").asText());
        MountainFire mountainFire = mountainService.getMountainFireFromAreaCode(mountain.getAreaCode());
        Map<String, String> map = new HashMap<String, String>();
        String fireValue = mountainFire.getMeanAvg();
        String fireGrade = mountainFire.getGrade();
        String fireDate = mountainFire.getAnalDate().format(DateTimeFormatter.ofPattern("M월dd일 H시"));
        map.put("resultFireValue", fireValue);
        map.put("resultFireGrade", fireGrade);
        map.put("resultFireDate", fireDate);
        map.put("resultFireValueDirect", fireValue);
        map.put("resultFireGradeDirect", fireGrade);
        map.put("resultFireDateDirect", fireDate);
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntTourInfoAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = mountainService.getMountainFromName(parametersFromNuguRequest.get("mountain").get("value").asText());
        Map<String, String> map = new HashMap<String, String>();
        String mntTourInfo = mountain.getTourismInfo();
        map.put("resultTour", mntTourInfo);
        map.put("resultTourDirect", mntTourInfo);
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntTransportAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = mountainService.getMountainFromName(parametersFromNuguRequest.get("mountain").get("value").asText());
        Map<String, String> map = new HashMap<String, String>();
        String mntTransportInfo = mountain.getTransport();
        map.put("resultTransport", mntTransportInfo);
        map.put("resultTransportDirect", mntTransportInfo);
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntHeightAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = mountainService.getMountainFromName(parametersFromNuguRequest.get("mountain").get("value").asText());
        Map<String, String> map = new HashMap<String, String>();
        String mntHeightInfo = String.valueOf(mountain.getMntHeight());
        map.put("resultHeight", mntHeightInfo);
        map.put("resultHeightDirect", mntHeightInfo);
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntReasonAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = mountainService.getMountainFromName(parametersFromNuguRequest.get("mountain").get("value").asText());
        Map<String, String> map = new HashMap<String, String>();
        String mntReasonInfo = mountain.getReason();
        map.put("resultReason", mntReasonInfo);
        map.put("resultReasonDirect", mntReasonInfo);
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntOverviewAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = mountainService.getMountainFromName(parametersFromNuguRequest.get("mountain").get("value").asText());
        Map<String, String> map = new HashMap<String, String>();
        String mntOverviewInfo = mountain.getReason();
        map.put("resultOverview", mntOverviewInfo);
        map.put("resultOverviewDirect", mntOverviewInfo);
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntClimbingCondition(JsonNode parametersFromNuguRequest) {
        Mountain mountain = mountainService.getMountainFromName(parametersFromNuguRequest.get("mountain").get("value").asText());
        log.info("로그 " + parametersFromNuguRequest.asText());
        String dayParameter = parametersFromNuguRequest.get("BID_DT_DAY").get("value").asText();
        Air air = weatherService.getAirFromAreaCode(mountain.getAreaCode());
        MountainFire mountainFire = mountainService.getMountainFireFromAreaCode(mountain.getAreaCode());
        WeatherSummaryResponse.Summary summary = weatherService.getWeatherSummary(mountain.getLat(), mountain.getLon());
        String resultConditionText = ClimbCondition.findByCondition(dayParameter, getTempCondition(dayParameter, summary), getAirCondition(air), getFireCondition(mountainFire), getSkyCondition(dayParameter, summary)).getResultText();
        Map<String, String> map = new HashMap<String, String>();
        map.put("resultConditionText", resultConditionText);
        return sendToNugu(map);
    }

    private NuguResponse sendToNugu(Map<String, String> outputMap) {
        NuguResponse nuguResponse = new NuguResponse();
        nuguResponse.setVersion("2.0");
        nuguResponse.setResultCode("OK");
        nuguResponse.setOutput(outputMap);
        return nuguResponse;
    }

    private boolean getTempCondition(String dayParameter, WeatherSummaryResponse.Summary summary) {
        String temp = "1";
        switch (dayParameter) {
//            case "BID_DT_DAY.TODAY":
            case "오늘":
                temp = summary.getToday().getTemperature().getTmax();
                break;
            case "BID_DT_DAY.TOMORROW":
                temp = summary.getTomorrow().getTemperature().getTmax();
                break;
            case "BID_DT_DAY.A_TOMORROW":
                temp = summary.getDayAfterTomorrow().getTemperature().getTmax();
                break;
        }
        return Double.parseDouble(temp) >= 33;
    }

    private boolean getSkyCondition(String dayParameter, WeatherSummaryResponse.Summary summary) {
        String skyName = "맑음";
        switch (dayParameter) {
            case "BID_DT_DAY.TODAY":
                skyName = summary.getToday().getSky().getName();
                break;
            case "BID_DT_DAY.TOMORROW":
                skyName = summary.getTomorrow().getSky().getName();
                break;
            case "BID_DT_DAY.A_TOMORROW":
                skyName = summary.getDayAfterTomorrow().getSky().getName();
                break;
        }
        return (skyName.equals("비") || skyName.equals("비 또는 눈"));
    }

    private boolean getAirCondition(Air air) {
        return (air.getAirValue() > 80);
    }

    private boolean getFireCondition(MountainFire mountainFire) {
        return (mountainFire.getGrade().equals("높음") || mountainFire.getGrade().equals("매우높음"));
    }
}
