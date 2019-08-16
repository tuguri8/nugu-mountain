package nugu.mountain.api.application.service;

import com.fasterxml.jackson.databind.JsonNode;
import nugu.mountain.api.interfaces.dto.request.NuguRequest;
import nugu.mountain.api.interfaces.dto.response.NuguResponse;

import java.io.IOException;

public interface NuguService {
    NuguResponse testFunc(JsonNode parameters) throws IOException;

    NuguResponse getMntInfoAction(JsonNode parameters);
}
