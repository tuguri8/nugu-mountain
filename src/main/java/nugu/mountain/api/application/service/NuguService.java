package nugu.mountain.api.application.service;

import com.fasterxml.jackson.databind.JsonNode;
import nugu.mountain.api.interfaces.dto.request.NuguRequest;
import nugu.mountain.api.interfaces.dto.response.NuguResponse;

import java.io.IOException;

public interface NuguService {
    NuguResponse testFunc(JsonNode parameters) throws IOException;

    NuguResponse getMntInfoAction(JsonNode parameters);

    NuguResponse getMntCourseAction(JsonNode parametersFromNuguRequest);

    NuguResponse getMntAirAction(JsonNode parametersFromNuguRequest);

    NuguResponse getMntWeatherAction(JsonNode parametersFromNuguRequest);

    NuguResponse getMntFireAction(JsonNode parametersFromNuguRequest);

    NuguResponse getMntTourInfoAction(JsonNode parametersFromNuguRequest);

    NuguResponse getMntTransportAction(JsonNode parametersFromNuguRequest);

    NuguResponse getMntHeightAction(JsonNode parametersFromNuguRequest);

    NuguResponse getMntReasonAction(JsonNode parametersFromNuguRequest);

    NuguResponse getMntOverviewAction(JsonNode parametersFromNuguRequest);

    NuguResponse getMntClimbingCondition(JsonNode parametersFromNuguRequest);
}
