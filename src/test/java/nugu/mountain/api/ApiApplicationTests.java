package nugu.mountain.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(ApiApplicationTests.class);

    @Test
    public void 지역명_테스트() {
        String str = "울산광역시, 경상북도 청도군, 경상남도 밀양시";
        str = Arrays.stream(str.split(",")).filter(x -> x.split(" ").length > 1).findFirst().orElse(str);
        log.info(str);
    }

}
