package nugu.mountain.api.application.service;

import com.google.common.collect.Lists;
import nugu.mountain.api.domain.entity.Air;
import nugu.mountain.api.domain.entity.Area;
import nugu.mountain.api.infrastructure.airkorea.AirkoreaClient;
import nugu.mountain.api.infrastructure.airkorea.AirkoreaResponse;
import nugu.mountain.api.infrastructure.repository.AirRepository;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class WeatherServicempl implements WeatherService {
    @Value("${airkorea-client.key}")
    String key;

    private static final Logger log = LoggerFactory.getLogger(WeatherServicempl.class);

    private final AirkoreaClient airkoreaClient;
    private final AirRepository airRepository;

    public WeatherServicempl(AirkoreaClient airkoreaClient, AirRepository airRepository) {
        this.airkoreaClient = airkoreaClient;
        this.airRepository = airRepository;
    }

    @Override
    @Scheduled(cron = "* 24 * * * *")
    public void syncAir() {
        AirkoreaResponse airkoreaResponse = airkoreaClient.getAir(key, "1", "1", "PM10", "HOUR", "WEEK");
        List<Air> airList = Lists.newArrayList();
        AirkoreaResponse.Item item = airkoreaResponse.getBody().getItems().getItem();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        airList.add(new Air.Builder(Area.findByenName("busan").getCode(),
                                    NumberUtils.toInt(item.getBusan()),
                                    LocalDateTime.parse(item.getDataTime(), dateTimeFormatter)).build());
        airList.add(new Air.Builder(Area.findByenName("chungbuk").getCode(),
                                    NumberUtils.toInt(item.getChungbuk()),
                                    LocalDateTime.parse(item.getDataTime(), dateTimeFormatter)).build());
        airList.add(new Air.Builder(Area.findByenName("chungnam").getCode(),
                                    NumberUtils.toInt(item.getChungnam()),
                                    LocalDateTime.parse(item.getDataTime(), dateTimeFormatter)).build());
        airList.add(new Air.Builder(Area.findByenName("daegu").getCode(),
                                    NumberUtils.toInt(item.getDaegu()),
                                    LocalDateTime.parse(item.getDataTime(), dateTimeFormatter)).build());
        airList.add(new Air.Builder(Area.findByenName("daejeon").getCode(),
                                    NumberUtils.toInt(item.getDaejeon()),
                                    LocalDateTime.parse(item.getDataTime(), dateTimeFormatter)).build());
        airList.add(new Air.Builder(Area.findByenName("gangwon").getCode(),
                                    NumberUtils.toInt(item.getGangwon()),
                                    LocalDateTime.parse(item.getDataTime(), dateTimeFormatter)).build());
        airList.add(new Air.Builder(Area.findByenName("gwangju").getCode(),
                                    NumberUtils.toInt(item.getGwangju()),
                                    LocalDateTime.parse(item.getDataTime(), dateTimeFormatter)).build());
        airList.add(new Air.Builder(Area.findByenName("gyeongbuk").getCode(),
                                    NumberUtils.toInt(item.getGyeongbuk()),
                                    LocalDateTime.parse(item.getDataTime(), dateTimeFormatter)).build());
        airList.add(new Air.Builder(Area.findByenName("gyeonggi").getCode(),
                                    NumberUtils.toInt(item.getGyeonggi()),
                                    LocalDateTime.parse(item.getDataTime(), dateTimeFormatter)).build());
        airList.add(new Air.Builder(Area.findByenName("gyeongnam").getCode(),
                                    NumberUtils.toInt(item.getGyeongnam()),
                                    LocalDateTime.parse(item.getDataTime(), dateTimeFormatter)).build());
        airList.add(new Air.Builder(Area.findByenName("incheon").getCode(),
                                    NumberUtils.toInt(item.getIncheon()),
                                    LocalDateTime.parse(item.getDataTime(), dateTimeFormatter)).build());
        airList.add(new Air.Builder(Area.findByenName("jeju").getCode(),
                                    NumberUtils.toInt(item.getJeju()),
                                    LocalDateTime.parse(item.getDataTime(), dateTimeFormatter)).build());
        airList.add(new Air.Builder(Area.findByenName("jeonbuk").getCode(),
                                    NumberUtils.toInt(item.getJeonbuk()),
                                    LocalDateTime.parse(item.getDataTime(), dateTimeFormatter)).build());
        airList.add(new Air.Builder(Area.findByenName("jeonnam").getCode(),
                                    NumberUtils.toInt(item.getJeonnam()),
                                    LocalDateTime.parse(item.getDataTime(), dateTimeFormatter)).build());
        airList.add(new Air.Builder(Area.findByenName("sejong").getCode(),
                                    NumberUtils.toInt(item.getSejong()),
                                    LocalDateTime.parse(item.getDataTime(), dateTimeFormatter)).build());
        airList.add(new Air.Builder(Area.findByenName("seoul").getCode(),
                                    NumberUtils.toInt(item.getSeoul()),
                                    LocalDateTime.parse(item.getDataTime(), dateTimeFormatter)).build());
        airList.add(new Air.Builder(Area.findByenName("ulsan").getCode(),
                                    NumberUtils.toInt(item.getUlsan()),
                                    LocalDateTime.parse(item.getDataTime(), dateTimeFormatter)).build());
        airRepository.saveAll(airList);
        log.info("미세먼지 저장 완료 : " + item.getDataTime() + " " + airList.size() + "개");
    }
}
