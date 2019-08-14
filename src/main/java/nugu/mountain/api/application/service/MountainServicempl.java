package nugu.mountain.api.application.service;

import com.google.common.collect.Lists;
import nugu.mountain.api.domain.entity.Area;
import nugu.mountain.api.domain.entity.Mountain;
import nugu.mountain.api.infrastructure.mountain.MountainClient;
import nugu.mountain.api.infrastructure.mountain.MountainResponse;
import nugu.mountain.api.infrastructure.repository.MountainRepository;
import nugu.mountain.api.infrastructure.sk.dto.GeocodingResponse;
import nugu.mountain.api.infrastructure.sk.SkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MountainServicempl implements MountainService {
    @Value("${mountain-client.key}")
    String key;

    @Value("${sk-client.key}")
    String skKey;

    private final MountainClient mountainClient;
    private final MountainRepository mountainRepository;
    private final SkClient skClient;
    private static final Logger log = LoggerFactory.getLogger(MountainServicempl.class);

    public MountainServicempl(MountainClient mountainClient,
                              MountainRepository mountainRepository, SkClient skClient) {
        this.mountainClient = mountainClient;
        this.mountainRepository = mountainRepository;
        this.skClient = skClient;
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
    public void syncMountainFire() {

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
