package nugu.mountain.api.infrastructure.sk.dto;

import java.util.List;

public class WeatherSummaryResponse {
    private Weather weather;

    public Weather getWeather() {
        return weather;
    }

    public static class Weather {
        private List<Summary> summary;

        public List<Summary> getSummary() {
            return summary;
        }
    }

    public static class Summary {
        private Grid grid;
        private String timeRelease;
        private Today today;
        private Tomorrow tomorrow;
        private DayAfterTomorrow dayAfterTomorrow;
        private Yesterday yesterday;

        public Grid getGrid() {
            return grid;
        }

        public String getTimeRelease() {
            return timeRelease;
        }

        public Today getToday() {
            return today;
        }

        public Tomorrow getTomorrow() {
            return tomorrow;
        }

        public DayAfterTomorrow getDayAfterTomorrow() {
            return dayAfterTomorrow;
        }

        public Yesterday getYesterday() {
            return yesterday;
        }
    }

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

    public static class Today {
        private Sky sky;
        private Temperature temperature;

        public Sky getSky() {
            return sky;
        }

        public Temperature getTemperature() {
            return temperature;
        }
    }

    public static class Tomorrow {
        private Sky sky;
        private Temperature temperature;

        public Sky getSky() {
            return sky;
        }

        public Temperature getTemperature() {
            return temperature;
        }
    }

    public static class Yesterday {
        private Sky sky;
        private Temperature temperature;

        public Sky getSky() {
            return sky;
        }

        public Temperature getTemperature() {
            return temperature;
        }
    }

    public static class DayAfterTomorrow {
        private Sky sky;
        private Temperature temperature;

        public Sky getSky() {
            return sky;
        }

        public Temperature getTemperature() {
            return temperature;
        }
    }

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
