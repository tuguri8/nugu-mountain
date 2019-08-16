package nugu.mountain.api.interfaces.dto.request;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.Map;

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

    public static class Event {
        private String type;

        public String getType() {
            return type;
        }
    }

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

    public static class Session {
        private String id;
        private String isNew;

        public String getId() {
            return id;
        }

        public String getIsNew() {
            return isNew;
        }
    }

    public static class Device {
        private String type;

        public String getType() {
            return type;
        }
    }
}
