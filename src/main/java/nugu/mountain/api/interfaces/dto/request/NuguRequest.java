package nugu.mountain.api.interfaces.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NuguRequest {
    private String version;
    private Action action;
    private Event event;
    private Context context;

    public String getVersion() {
        return version;
    }

    public Action getAction() {
        return action;
    }

    public Event getEvent() {
        return event;
    }

    public Context getContext() {
        return context;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Action {
        private String actionName;
        private Map<String, Object> parameters;

        public String getActionName() {
            return actionName;
        }

        public Map<String, Object> getParameters() {
            return parameters;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Event {
        private String type;

        public String getType() {
            return type;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Context {
        private Session session;
        private Device device;

        public Session getSession() {
            return session;
        }

        public Device getDevice() {
            return device;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Session {
        private String id;
        @JsonProperty(value="isNew")
        private Boolean isNew;
        @JsonProperty(value="isPlayBuilderRequest")
        private Boolean isPlayBuilderRequest;

        public Boolean getPlayBuilderRequest() {
            return isPlayBuilderRequest;
        }

        public String getId() {
            return id;
        }

        public Boolean getNew() {
            return isNew;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Device {
        private String type;

        public String getType() {
            return type;
        }
    }
}
