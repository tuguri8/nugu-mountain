package nugu.mountain.api.application.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import nugu.mountain.api.interfaces.dto.request.NuguRequest;
import nugu.mountain.api.interfaces.dto.response.NuguResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class NuguServicempl implements NuguService {

    private static final Logger log = LoggerFactory.getLogger(NuguServicempl.class);

    @Override
    public NuguResponse testFunc(NuguRequest nuguRequest) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode parameterNode = objectMapper.readTree(objectMapper.writeValueAsString(nuguRequest.getAction().getParameters()));
        String result = parameterNode.get("name").get("value").asText();
        log.info(result);
        NuguResponse nuguResponse = new NuguResponse();
        nuguResponse.setVersion("2.0");
        nuguResponse.setResultCode("OK");
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", result);
        nuguResponse.setOutput(map);
        return nuguResponse;
    }
}
