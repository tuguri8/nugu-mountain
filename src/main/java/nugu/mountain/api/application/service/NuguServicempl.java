package nugu.mountain.api.application.service;

import com.fasterxml.jackson.databind.JsonNode;
import nugu.mountain.api.domain.entity.Air;
import nugu.mountain.api.domain.entity.Mountain;
import nugu.mountain.api.domain.entity.MountainFire;
import nugu.mountain.api.infrastructure.repository.AirRepository;
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

    @Value("${sk-client.key}")
    String key;

    private final MountainRepository mountainRepository;
    private final AirRepository airRepository;
    private final MountainFireRepository mountainFireRepository;
    private final SkClient skClient;

    private static final Logger log = LoggerFactory.getLogger(NuguServicempl.class);

    public NuguServicempl(MountainRepository mountainRepository,
                          AirRepository airRepository,
                          MountainFireRepository mountainFireRepository, SkClient skClient) {
        this.mountainRepository = mountainRepository;
        this.airRepository = airRepository;
        this.mountainFireRepository = mountainFireRepository;
        this.skClient = skClient;
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
        Mountain mountain = getMountainFromParameters(parameters);
        Map<String, String> map = new HashMap<String, String>();
        map.put("resultText",
                mountain.getSubName() + " " + mountain.getMntName() + "에 대해 궁금하시군요! 산 높이, 등산 코스 정보, 날씨, 미세먼지, 산불위험지수, 100대명산 선정이유, " +
                    "대중교통정보, 주변관광정보, 산정보개관 중 어떤게 궁금하세요?");
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntCourseAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = getMountainFromParameters(parametersFromNuguRequest);
        Map<String, String> map = new HashMap<String, String>();
        map.put("resultCourse", mountain.getEtcCourse());
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntAirAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = getMountainFromParameters(parametersFromNuguRequest);
        Air air = airRepository.findTopByAreaCodeOrderById(mountain.getAreaCode())
                               .orElseThrow(() -> new RuntimeException("미세먼지 정보가 존재하지 않습니다"));
        Map<String, String> map = new HashMap<String, String>();
        map.put("resultAirValue", air.getAirValue().toString());
        map.put("resultAirGrade", getAirGradeFromValue(air.getAirValue()));
        map.put("resultAirDate", air.getDataTime().format(DateTimeFormatter.ofPattern("M월dd일 H시")));
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntWeatherAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = getMountainFromParameters(parametersFromNuguRequest);
        WeatherSummaryResponse weatherSummaryResponse = skClient.getWeatherSummary(key, "2", mountain.getLat(), mountain.getLon());
        WeatherSummaryResponse.Summary summary = weatherSummaryResponse.getWeather().getSummary().get(0);

        Map<String, String> map = new HashMap<String, String>();
        map.put("resultWeatherText",
                String.format("%s의 일기예보를 알려드릴게요!, 오늘의 기상은 %s, 최고기온은 %s, 최저기온은 %s 입니다. 내일의 기상은 %s, 최고기온은 %s, 최저기온은 %s 입니다.",
                              mountain.getMntName(),
                              summary.getToday().getSky().getName(),
                              summary.getToday().getTemperature().getTmax() + "도",
                              summary.getToday().getTemperature().getTmin() + "도",
                              summary.getTomorrow().getSky().getName(),
                              summary.getTomorrow().getTemperature().getTmax() + "도",
                              summary.getTomorrow().getTemperature().getTmin() + "도"));
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntFireAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = getMountainFromParameters(parametersFromNuguRequest);
        MountainFire mountainFire = mountainFireRepository.findTopByAreaCodeOrderById(mountain.getAreaCode())
                                                          .orElseThrow(() -> new RuntimeException("산불 위험 정보가 존재하지 않습니다"));
        Map<String, String> map = new HashMap<String, String>();
        map.put("resultFireValue", mountainFire.getMeanAvg());
        map.put("resultFireGrade", mountainFire.getGrade());
        map.put("resultFireDate", mountainFire.getAnalDate().format(DateTimeFormatter.ofPattern("M월dd일 H시")));
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntTourInfoAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = getMountainFromParameters(parametersFromNuguRequest);
        Map<String, String> map = new HashMap<String, String>();
        map.put("resultTour", mountain.getTourismInfo());
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntTransportAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = getMountainFromParameters(parametersFromNuguRequest);
        Map<String, String> map = new HashMap<String, String>();
        map.put("resultTransport", mountain.getTransport());
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntHeightAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = getMountainFromParameters(parametersFromNuguRequest);
        Map<String, String> map = new HashMap<String, String>();
        map.put("resultHeight", String.valueOf(mountain.getMntHeight()));
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntReasonAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = getMountainFromParameters(parametersFromNuguRequest);
        Map<String, String> map = new HashMap<String, String>();
        map.put("resultReason", mountain.getReason());
        return sendToNugu(map);
    }

    @Override
    public NuguResponse getMntOverviewAction(JsonNode parametersFromNuguRequest) {
        Mountain mountain = getMountainFromParameters(parametersFromNuguRequest);
        Map<String, String> map = new HashMap<String, String>();
        map.put("resultOverview", mountain.getReason());
        return sendToNugu(map);
    }

    private Mountain getMountainFromParameters(JsonNode parameters) {
        String mntName = parameters.get("mountain").get("value").asText();
        return mountainRepository.findByMntName(mntName).orElseThrow(() -> new RuntimeException("해당 산이 존재하지 않습니다"));
    }

    private NuguResponse sendToNugu(Map<String, String> outputMap) {
        NuguResponse nuguResponse = new NuguResponse();
        nuguResponse.setVersion("2.0");
        nuguResponse.setResultCode("OK");
        nuguResponse.setOutput(outputMap);
        return nuguResponse;
    }

    private String getAirGradeFromValue(Integer airValue) {
        String grade = "낮음";
        if (airValue > 150) {
            grade = "매우나쁨";
        } else if (airValue > 80) {
            grade = "나쁨";
        } else if (airValue > 30) {
            grade = "보통";
        }
        return grade;
    }
}
