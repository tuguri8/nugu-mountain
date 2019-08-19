package nugu.mountain.api.interfaces.dto.response;

import java.util.Map;

public class NuguResponse {
    private String version;
    private String resultCode;
    private Map<String, String> output;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public Map<String, String> getOutput() {
        return output;
    }

    public void setOutput(Map<String, String> output) {
        this.output = output;
    }
}
