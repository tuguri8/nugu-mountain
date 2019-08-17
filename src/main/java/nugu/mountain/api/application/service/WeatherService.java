package nugu.mountain.api.application.service;

import nugu.mountain.api.domain.entity.Air;

public interface WeatherService {
    void syncAir();

    Air getAirFromAreaCode(String areaCode);

    String getAirGradeFromValue(Integer airValue);
}
