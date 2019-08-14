package nugu.mountain.api.domain.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Area {
    SEOUL("서울특별시", "11", "seoul"),
    SEJONG("세종특별시", "36", "sejong"),
    SEJONG2("세종특별자치시", "36", "sejong"),
    JEJU("제주특별자치도", "50", "jeju"),
    JEJU2("제주도", "50", "jeju"),
    BUSAN("부산광역시", "26", "busan"),
    DAEGU("대구광역시", "27", "daegu"),
    INCHEON("인천광역시", "28", "incheon"),
    GWANGJU("광주광역시", "29", "gwangju"),
    DAEJEON("대전광역시", "30", "daejeon"),
    ULSAN("울산광역시", "31", "ulsan"),
    JEONBUK("전라북도", "45", "jeonbuk"),
    JEONNAM("전라남도", "46", "jeonnam"),
    JEONNAM2("전남", "46", "jeonnam"),
    CHUNGBUK("충청북도", "43", "chungbuk"),
    CHUNGNAM("충청남도", "44", "chungnam"),
    GYEONGBUK("경상북도", "47", "gyeongbuk"),
    GYEONGNAM("경상남도", "48", "gyeongnam"),
    GANGWON("강원도", "42", "gangwon"),
    GANGWON2("강원", "42", "gangwon"),
    GYEONGGI("경기도", "41", "gyeonggi"),
    UNKNOWN;

    private String koName;
    private String code;
    private String enName;

    Area(String koName, String code, String enName) {
        this.koName = koName;
        this.code = code;
        this.enName = enName;
    }

    Area() {

    }

    public String getKoName() {
        return koName;
    }

    public String getCode() {
        return code;
    }

    public String getEnName() {
        return enName;
    }

    public static Area findBykoName(String koName) {
        return Arrays.stream(Area.values())
                     .filter(area -> koName.equals(area.getKoName()))
                     .findAny()
                     .orElse(UNKNOWN);
    }

    public static Area findByenName(String enName) {
        return Arrays.stream(Area.values())
                     .filter(area -> enName.equals(area.getEnName()))
                     .findAny()
                     .orElse(UNKNOWN);
    }

    public static List<String> getAllAreaCode() {
        return Arrays.stream(Area.values())
                     .map(Area::getCode)
                     .collect(Collectors.toList())
                     .stream()
                     .distinct()
                     .collect(Collectors.toList());
    }
}
