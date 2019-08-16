package nugu.mountain.api.infrastructure.sk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherSummaryResponse {
    private Weather weather;

    public Weather getWeather() {
        return weather;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Weather {
        private List<Summary> summary;

        public List<Summary> getSummary() {
            return summary;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Summary {
        private Grid grid;
        private String timeRelease;
        private SummaryInfo today;
        private SummaryInfo tomorrow;
        private SummaryInfo dayAfterTomorrow;
        private SummaryInfo yesterday;

        public Grid getGrid() {
            return grid;
        }

        public String getTimeRelease() {
            return timeRelease;
        }

        public SummaryInfo getToday() {
            return today;
        }

        public SummaryInfo getTomorrow() {
            return tomorrow;
        }

        public SummaryInfo getDayAfterTomorrow() {
            return dayAfterTomorrow;
        }

        public SummaryInfo getYesterday() {
            return yesterday;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Grid {
        private String latitude;
        private String longitude;
        private String city;
        private String county;
        private String village;

        public String getLatitude() {
            return latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public String getCity() {
            return city;
        }

        public String getCounty() {
            return county;
        }

        public String getVillage() {
            return village;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SummaryInfo {
        private Sky sky;
        private Temperature temperature;

        public Sky getSky() {
            return sky;
        }

        public Temperature getTemperature() {
            return temperature;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sky {
        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Temperature {
        private String tmax;
        private String tmin;

        public String getTmax() {
            return tmax;
        }

        public String getTmin() {
            return tmin;
        }
    }

    @Override
    public String toString() {
        return "WeatherSummaryResponse{" +
            "weather=" + weather +
            '}';
    }
}
