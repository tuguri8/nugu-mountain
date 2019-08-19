package nugu.mountain.api.application.service;

import nugu.mountain.api.domain.entity.Air;
import nugu.mountain.api.infrastructure.sk.dto.WeatherSummaryResponse;

import java.util.List;

public interface WeatherService {
    void syncAir();

    Air getAirFromAreaCode(String areaCode);

    String getAirGradeFromValue(Integer airValue);

    WeatherSummaryResponse.Summary getWeatherSummary(String lat, String lon);

    List<String> getFreshAreaCode();
}
