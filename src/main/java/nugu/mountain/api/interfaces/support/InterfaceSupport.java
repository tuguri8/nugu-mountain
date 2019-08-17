package nugu.mountain.api.interfaces.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import nugu.mountain.api.interfaces.dto.request.NuguRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class InterfaceSupport {

    private static final Logger log = LoggerFactory.getLogger(InterfaceSupport.class);

    public static JsonNode getParametersFromNuguRequest (NuguRequest nuguRequest) throws IOException {
        log.info(nuguRequest.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(objectMapper.writeValueAsString(nuguRequest.getAction().getParameters()));
    }
}
