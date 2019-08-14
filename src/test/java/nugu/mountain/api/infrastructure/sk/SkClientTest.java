package nugu.mountain.api.infrastructure.sk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkClientTest {
    @Value("${sk-client.key}")
    String key;

    @Autowired
    private SkClient skClient;

    @Test
    public void SK_간편날씨() {
        skClient.getWeatherSummary(key, "2", "37.817645", "127.715623");
    }

}