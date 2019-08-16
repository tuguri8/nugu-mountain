package nugu.mountain.api.application.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NuguServicemplTest {

    private static final Logger log = LoggerFactory.getLogger(NuguServicemplTest.class);


    @Test
    public void 날짜_문자열변경_테스트() {
        LocalDateTime localDateTime = LocalDateTime.parse("2019-08-14 16:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info(localDateTime.format(DateTimeFormatter.ofPattern("M월dd일 H시")));
    }
}