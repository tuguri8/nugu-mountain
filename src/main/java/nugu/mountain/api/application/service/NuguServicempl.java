package nugu.mountain.api.application.service;

import com.fasterxml.jackson.databind.JsonNode;
import nugu.mountain.api.domain.entity.Mountain;
import nugu.mountain.api.infrastructure.repository.MountainRepository;
import nugu.mountain.api.interfaces.dto.response.NuguResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NuguServicempl implements NuguService {

    private final MountainRepository mountainRepository;

    private static final Logger log = LoggerFactory.getLogger(NuguServicempl.class);

    public NuguServicempl(MountainRepository mountainRepository) {this.mountainRepository = mountainRepository;}

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
        String mntName = parameters.get("mountain").get("value").asText();
        Mountain mountain = mountainRepository.findByMntName(mntName).orElseThrow(() -> new RuntimeException("해당 산이 존재하지 않습니다"));
        Map<String, String> map = new HashMap<String, String>();
        map.put("resultText", mountain.getSubName() + " " + mntName + "에 대해 궁금하시군요! 산 높이, 등산 코스 정보, 날씨, 미세먼지, 산불위험지수, 100대명산 선정이유, 대중교통정보, 주변관광정보, 산정보개관 중 어떤게 궁금하세요?");
        return sendToNugu(map);
    }

    private NuguResponse sendToNugu(Map<String, String> outputMap) {
        NuguResponse nuguResponse = new NuguResponse();
        nuguResponse.setVersion("2.0");
        nuguResponse.setResultCode("OK");
        nuguResponse.setOutput(outputMap);
        return nuguResponse;
    }
}
