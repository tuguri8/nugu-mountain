package nugu.mountain.api.application.service;

import nugu.mountain.api.domain.entity.Air;
import nugu.mountain.api.domain.entity.MountainFire;
import nugu.mountain.api.infrastructure.sk.dto.WeatherSummaryResponse;

import java.util.Arrays;

public enum ClimbCondition {
    TODAY_OK("오늘", false, false, false, false, "오늘은 미세먼지도 좋고, 산불위험도 없고, 적정온도에 비도 안오는 등산하기 딱 좋은 조건이네요! 즐거운 등산하시길 바랄게요!"),
    TODAY_HOT("오늘",
              true,
              false,
              false,
              false,
              "다음에 가시는건 어떠세요? 오늘 미세먼지, 산불위험은 다 괜찮은데... 온도가 너무 높네요! 폭염의 날씨에서 등산하는 건 무리가 될 수 있어요!"),
    TODAY_AIR("오늘", false, true, false, false, "오늘은 안돼요! 미세먼지가 많은 날씨에요. 보이지 않는다고 안심하시면 안됩니다!"),
    TODAY_FIRE("오늘", false, false, true, false, "다른날로 미루시는건 어때요? 오늘은 산불위험이 있어요! 혹시모를 위험도 대비하는게 좋을 것 같아요!"),
    TODAY_RAIN("오늘", false, false, false, true, "오늘은 비가 와서 안될 것 같네요! 다른 날로 미루시길 바랄게요!"),
    TODAY_HOT_AIR("오늘", true, true, false, false, "다음에 가시는건 어떠세요? 오늘은 너무 덥고 미세먼지도 안좋아요...! 건강을 지키려는 산행이 건강을 해칠 수 있답니다!"),
    TODAY_HOT_RAIN("오늘", true, false, false, true, "다음에 가시는걸 추천해드릴게요! 오늘은 폭염에 비까지 오네요!"),
    TODAY_HOT_FIRE("오늘",
                   true,
                   false,
                   true,
                   false,
                   "다음에 가시는건 어떠세요? 오늘 미세먼지는 괜찮은데... 온도가 너무 높고 산불위험도 있어요! 폭염의 날씨에서 등산하는 건 무리가 될 수 있어요!"),
    TODAY_AIR_FIRE("오늘", false, true, true, false, "오늘은 안됩니다! 산불위험도 있고 비까지 내리네요!"),
    TODAY_AIR_RAIN("오늘", false, true, false, true, "다음에 가시는건 어떠세요? 오늘은 비도 내리고 미세먼지도 좋지 않네요."),
    TODAY_FIRE_RAIN("오늘", false, false, true, true, "다음에 가시는건 어떠세요? 오늘은 산불위험에 비까지 내리네요!"),
    TOMORROW_OK("내일", false, false, false, false, "내일은 산불위험도 없고, 적정온도에 비도 안오는 등산하기 좋은 조건이네요! 내일 등산을 추천드릴게요!"),
    TOMORROW_HOT("내일",
                 true,
                 false,
                 false,
                 false,
                 "다음에 가시는건 어떠세요? 내일 다른건 다 괜찮은데... 온도가 너무 높네요! 폭염의 날씨에서 등산하는 건 무리가 될 수 있어요!"),
    TOMORROW_RAIN("내일", false, false, false, true, "내일은 비가 와서 안될 것 같네요! 다른 날로 미루시길 바랄게요!"),
    TOMORROW_FIRE("내일", false, false, true, false, "다른날로 미루시는건 어때요? 내일은 산불위험이 있어요! 혹시모를 위험도 대비하는게 좋을 것 같아요!"),
    TOMORROW_HOT_RAIN("내일", true, false, false, true, "다음에 가시는걸 추천해드릴게요! 내일은 폭염에 비까지 오네요!"),
    TOMORROW_HOT_FIRE("내일",
                      true,
                      false,
                      true,
                      false,
                      "다음에 가시는건 어떠세요? 내일은 온도가 너무 높고 산불위험도 있어요! 폭염의 날씨에서 등산하는 건 무리가 될 수 있어요!"),
    TOMORROW_RAIN_FIRE("내일", false, false, true, true, "다음에 가시는건 어떠세요? 내일은 산불위험에 비까지 내리네요!"),
    ATOMORROW_OK("모레", false, false, false, false, "내일 모레는 산불위험도 없고, 적정온도에 비도 안오는 등산하기 좋은 조건이네요! 내일 모레 등산을 추천드릴게요!"),
    ATOMORROW_HOT("모레", true, false, false, false, "다음에 가시는건 어떠세요? 내일모레는 온도가 너무 높아요! 폭염의 날씨에서 등산하는 건 무리가 될 수 있어요!"),
    ATOMORROW_RAIN("모레", false, false, false, true, "내일모레는 비가 와서 안될 것 같네요! 다른 날로 미루시길 바랄게요!"),
    ATOMORROW_FIRE("모레", false, false, true, false, "다른날로 미루시는건 어때요? 내일모레는 산불위험이 있어요! 혹시모를 위험도 대비하는게 좋을 것 같아요!"),
    ATOMORROW_HOT_RAIN("모레", true, false, false, true, "다음에 가시는걸 추천해드릴게요! 내일모레는 폭염에 비까지 오네요!"),
    ATOMORROW_HOT_FIRE("모레",
                       true,
                       false,
                       true,
                       false,
                       "다음에 가시는건 어떠세요? 내일모레는 온도가 너무 높고 산불위험도 있어요! 폭염의 날씨에서 등산하는 건 무리가 될 수 있어요!"),
    ATOMORROW_RAIN_FIRE("모레", false, false, true, true, "다음에 가시는건 어떠세요? 내일모레는 산불위험에 비까지 내리네요!"),
    UNKNOWN("UNKNOWN", false, false, false, false, "등산 여부 추천 서비스는 오늘, 내일, 내일모레만 제공하고 있어요! 다시 물어봐주세요!");

    private String dayParameter;
    private boolean hotTemp;
    private boolean airPollution;
    private boolean mountainFire;
    private boolean rainWeather;
    private String resultText;

    ClimbCondition(String dayParameter,
                   boolean hotTemp,
                   boolean airPollution,
                   boolean mountainFire,
                   boolean rainWeather,
                   String resultText) {
        this.dayParameter = dayParameter;
        this.hotTemp = hotTemp;
        this.airPollution = airPollution;
        this.mountainFire = mountainFire;
        this.rainWeather = rainWeather;
        this.resultText = resultText;
    }

    ClimbCondition() {

    }

    public String getDayParameter() {
        return dayParameter;
    }

    public boolean isHotTemp() {
        return hotTemp;
    }

    public boolean isAirPollution() {
        return airPollution;
    }

    public boolean isMountainFire() {
        return mountainFire;
    }

    public boolean isRainWeather() {
        return rainWeather;
    }

    public String getResultText() {
        return resultText;
    }

    public static ClimbCondition findByCondition(String dayParameter,
                                                 boolean hotCondition,
                                                 boolean airCondition,
                                                 boolean fireCondition,
                                                 boolean rainCondition) {
        return Arrays.stream(ClimbCondition.values())
                     .filter(climbCondition -> dayParameter.equals(climbCondition.getDayParameter()))
                     .filter(climbCondition -> climbCondition.isHotTemp() == hotCondition)
                     .filter(climbCondition -> climbCondition.isAirPollution() == airCondition)
                     .filter(climbCondition -> climbCondition.isMountainFire() == fireCondition)
                     .filter(climbCondition -> climbCondition.isRainWeather() == rainCondition)
                     .findAny()
                     .orElse(UNKNOWN);
    }
}
