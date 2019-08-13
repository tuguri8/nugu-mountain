package nugu.mountain.api.infrastructure.sk.dto;

import java.util.List;

public class WeatherSummaryResponse {
    private Weather weather;

    public static class Weather {
        private List<Summary> summary;

    }

    public static class Summary {
        private Grid grid;
        private String timeRelease;
        private Today today;
        private Tomorrow tomorrow;
        private DayAfterTomorrow dayAfterTomorrow;
        private Yesterday yesterday;

    }

    public static class Grid {
        private String latitude;
        private String longitude;
        private String city;
        private String county;
        private String village;
    }

    public static class Today {
        private Sky sky;
        private Temperature temperature;
    }

    public static class Tomorrow {
        private Sky sky;
        private Temperature temperature;
    }

    public static class Yesterday {
        private Sky sky;
        private Temperature temperature;
    }

    public static class DayAfterTomorrow {
        private Sky sky;
        private Temperature temperature;
    }

    public static class Sky {
        private String code;
        private String name;
    }

    public static class Temperature {
        private String tmax;
        private String tmin;
    }

    @Override
    public String toString() {
        return "WeatherSummaryResponse{" +
            "weather=" + weather +
            '}';
    }
}
