package nugu.mountain.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(ApiApplicationTests.class);

    @Test
    public void 테스트() {
        log.info("test");
    }

}
