package nugu.mountain.api.application.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Test
    public void 등산로_시간_계산() {
        String str = "첫 번째 코스입니다. 나본들고개,정상,육괴정 를 지나는 코스로 시간은 총 1시간 30분 소요됩니다.두 번째 코스입니다. 노루목,정상,계단길,수덕사 를 지나는 코스로 시간은 총 1시간 20분 소요됩니다.세 " +
            "번째 코스입니다. 주차장,동남릉,정상,150봉,삼승리 를 지나는 코스로 시간은 총 1시간 40분 소요됩니다.";
        String[] routeArr = str.split("\\.");
        List<Integer> hour = Arrays.stream(routeArr)
                                   .filter(x -> x.contains("소요됩"))
                                   .map(this::extractTime).sorted().collect(Collectors.toList());
        log.info(hour.get(0).toString());
    }

    private Integer extractTime(String route) {
        Integer hour = Integer.valueOf(route.substring(route.indexOf("총 ") + 2, route.indexOf("시간 ")));
        Integer min = Integer.valueOf(route.substring(route.indexOf("시간 ") + 3, route.indexOf("분 ")));
        return (hour * 60 + min);
    }
}