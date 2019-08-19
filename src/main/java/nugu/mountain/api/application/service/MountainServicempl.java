package nugu.mountain.api.application.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import nugu.mountain.api.domain.entity.Area;
import nugu.mountain.api.domain.entity.Mountain;
import nugu.mountain.api.domain.entity.MountainFire;
import nugu.mountain.api.infrastructure.mountain.MountainClient;
import nugu.mountain.api.infrastructure.mountain.MountainResponse;
import nugu.mountain.api.infrastructure.nifos.NifosClient;
import nugu.mountain.api.infrastructure.nifos.NifosMountainFireResponse;
import nugu.mountain.api.infrastructure.repository.MountainFireRepository;
import nugu.mountain.api.infrastructure.repository.MountainRepository;
import nugu.mountain.api.infrastructure.sk.dto.GeocodingResponse;
import nugu.mountain.api.infrastructure.sk.SkClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MountainServicempl implements MountainService {
    @Value("${mountain-client.key}")
    String key;

    @Value("${sk-client.key}")
    String skKey;

    @Value("${nifos-client.key}")
    String nifosKey;

    private final MountainClient mountainClient;
    private final MountainRepository mountainRepository;
    private final MountainFireRepository mountainFireRepository;
    private final SkClient skClient;
    private final NifosClient nifosClient;
    private static final Logger log = LoggerFactory.getLogger(MountainServicempl.class);

    public MountainServicempl(MountainClient mountainClient,
                              MountainRepository mountainRepository,
                              MountainFireRepository mountainFireRepository, SkClient skClient,
                              NifosClient nifosClient) {
        this.mountainClient = mountainClient;
        this.mountainRepository = mountainRepository;
        this.mountainFireRepository = mountainFireRepository;
        this.skClient = skClient;
        this.nifosClient = nifosClient;
    }

    @Override
    public void getMountain() {
        String mountainStr = "가리산 가리왕산 가야산 가지산 감악산 강천산 계룡산 계방산 공작산 관악산 구병산 금산 금수산 금오산 금정산 깃대봉 남산 내연산 내장산 대둔산 대암산 대야산 덕숭산 덕유산 덕항산 도락산 도봉산 " +
            "두륜산 두타산 마니산 마이산 명성산 명지산 모악산 무등산 무학산 미륵산 민주지산 방장산 방태산 백덕산 백암산 백운산(광양) 백운산(정선) 백운산(포천) 변산 북한산 비슬산 삼악산 서대산 선운산 설악산 성인봉 소백산 소요산 " +
            "속리산 신불산 연화산 오대산 오봉산 용문산 용화산 운문산 운악산 운장산 월악산 월출산 유명산 응봉산 장안산 재약산 적상산 점봉산 조계산 주왕산 주흘산 지리산 지리산(통영) 천관산 천마산 천성산 천태산 청량산 추월산 축령산 " +
            "치악산 칠갑산 태백산 태화산 팔공산 팔봉산 팔영산 한라산 화악산 화왕산 황매산 황석산 황악산 황장산 희양산";
        String[] mountainArr = mountainStr.split(" ");
        List<MountainResponse> mountainResponseList = Lists.newArrayList();
        for (String mntName : mountainArr) {
            try {
                MountainResponse mountainResponse = mountainClient.getMountain(key, mntName, "1", "10");
                mountainResponseList.add(mountainResponse);
                log.info(mountainResponse.getBody().getItems().getItem().get(0).getMntnm());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.info(e.getMessage());
            }
        }
        List<Mountain> mountainList = mountainResponseList.stream()
                                                          .map(this::transform)
                                                          .collect(Collectors.toList());
        log.info("산 정보 저장 완료 : " + mountainList.size() + " 개");
        mountainRepository.saveAll(mountainList);
    }

    @Override
    public void geocoding() {
        List<Mountain> mountainList = mountainRepository.findAll();
        for (Mountain mountain : mountainList) {
            try {
                String geocodingKeyword = mountain.getMntArea();
                geocodingKeyword = Arrays.stream(geocodingKeyword.split(","))
                                         .filter(x -> x.split(" ").length > 1)
                                         .findFirst()
                                         .orElse(geocodingKeyword);
                GeocodingResponse geocodingResponse = skClient.geocoding(skKey, "1", geocodingKeyword);
                mountain.setLat(geocodingResponse.getCoordinateInfo().getCoordinate().get(0).getLat());
                mountain.setLon(geocodingResponse.getCoordinateInfo().getCoordinate().get(0).getLon());
                // Enum에서 지역코드 받아와서 추가
                mountain.setAreaCode(Area.findBykoName(geocodingKeyword.split(" ")[0]).getCode());
                mountainRepository.save(mountain);
                log.info(mountain.getMntName() + "에 대한 lat, lon 저장 완료");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.info(e.getMessage());
            }
        }
    }

    @Override
    @CacheEvict(value = "mntfire", allEntries = true)
    @Scheduled(cron = "0 20 * * * *")
    public void syncMountainFire() {
        List<String> areaList = Area.getAllAreaCode();
        List<MountainFire> mountainFireList = areaList.stream()
                                                      .map(this::getMountainFireRateFromArea)
                                                      .collect(Collectors.toList());
        mountainFireRepository.saveAll(mountainFireList);
        log.info("산불위험 DB 저장 완료 : " + mountainFireList.size() + " 개");
    }

    @Override
    @Cacheable(value = "mntfire", key = "#areaCode")
    public MountainFire getMountainFireFromAreaCode(String areaCode) {
        return mountainFireRepository.findTopByAreaCodeOrderByIdDesc(areaCode)
                                     .orElseThrow(() -> new RuntimeException("산불 위험 정보가 존재하지 않습니다"));
    }

    @Override
    @Cacheable(value = "mntinfo", key = "#mntName")
    public Mountain getMountainFromName(String mntName) {
        return mountainRepository.findByMntName(mntName).orElseThrow(() -> new RuntimeException("해당 산이 존재하지 않습니다"));
    }

    @Override
    @Cacheable(value = "areamntinfo", key = "#areaCode")
    public List<Mountain> getMountainAreaCode(String areaCode) {
        return mountainRepository.findAllByAreaCode(areaCode).orElse(Collections.EMPTY_LIST);
    }

    @Override
    public List<String> getSafeAreaCodeFromFire() {
        List<MountainFire> mountainFireList = mountainFireRepository.findTop18ByOrderByIdDesc().orElse(Collections.EMPTY_LIST);
        return mountainFireList.stream()
                      .filter(mountainFire -> mountainFire.getGrade().equals("보통") || mountainFire.getGrade().equals("낮음"))
                      .filter(mountainFire -> mountainFire.getAreaCode() != null)
                      .map(MountainFire::getAreaCode)
                      .collect(Collectors.toList());
    }

    private MountainFire getMountainFireRateFromArea(String areaCode) {
        NifosMountainFireResponse nifosMountainFireResponse = nifosClient.getMountainFireRate(nifosKey, areaCode, "sido", "1.1", "1");
        NifosMountainFireResponse.Items items = nifosMountainFireResponse.getOutputData().getItems();
        MountainFire mountainFire = new MountainFire();
        mountainFire.setAreaCode(areaCode);
        mountainFire.setAnalDate(LocalDateTime.parse(items.getAnaldate(), DateTimeFormatter.ofPattern("yyyy/MM/dd/HH")));
        mountainFire.setMeanAvg(items.getMeanavg());
        mountainFire.setGrade(getFireGradeFromAvg(items.getMeanavg()));
        return mountainFire;
    }

    private String getFireGradeFromAvg(String meanAvg) {
        Double meanAvgValue = Double.valueOf(meanAvg);
        String grade = "낮음";
        if (meanAvgValue > 85) {
            grade = "매우높음";
        } else if (meanAvgValue > 65) {
            grade = "높음";
        } else if (meanAvgValue > 50) {
            grade = "보통";
        }
        return grade;
    }

    private Mountain transform(MountainResponse mountainResponse) {
        MountainResponse.Item item = mountainResponse.getBody().getItems().getItem().get(0);
        Mountain mountain = new Mountain();
        mountain.setMntCode(Long.valueOf(item.getMntncd()));
        mountain.setMntName(item.getMntnm());
        mountain.setSubName(item.getSubnm());
        mountain.setMntArea(item.getAreanm());
        mountain.setMntHeight(Integer.valueOf(item.getMntheight()));
        mountain.setReason(item.getAeatreason());
        mountain.setOverview(item.getOverview());
        mountain.setDetails(item.getDetails());
        mountain.setTransport(item.getTransport());
        mountain.setTourismInfo(item.getTourisminf());
        mountain.setEtcCourse(item.getEtccourse());
        return mountain;
    }
}
