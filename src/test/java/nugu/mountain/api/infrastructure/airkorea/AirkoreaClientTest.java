package nugu.mountain.api.infrastructure.airkorea;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirkoreaClientTest {
    @Value("${airkorea-client.key}")
    String key;

    @Autowired
    private AirkoreaClient airkoreaClient;

    @Test
    public void 미세먼지_조회_테스트() {
        airkoreaClient.getAir(key, "1", "1", "PM10", "HOUR", "WEEK");
    }

}