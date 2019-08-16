package nugu.mountain.api.interfaces.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import nugu.mountain.api.interfaces.dto.request.NuguRequest;

import java.io.IOException;

public class InterfaceSupport {

    public static JsonNode getParametersFromNuguRequest (NuguRequest nuguRequest) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(objectMapper.writeValueAsString(nuguRequest.getAction().getParameters()));
    }
}
