package nugu.mountain.api.infrastructure.nifos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "metadata")
@XmlAccessorType(XmlAccessType.FIELD)
public class NifosMountainFireResponse {
    @XmlElement(name = "resultSummary")
    private ResultSummary resultSummary;
    @XmlElement(name = "inputData")
    private InputData inputData;
    @XmlElement(name = "outputData")
    private OutputData outputData;

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ResultSummary {
        private String totalCnt;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class InputData {
        @XmlElement(name = "keyValue")
        private String keyValue;
        @XmlElement(name = "version")
        private String version;
        @XmlElement(name = "localarea")
        private String localarea;
        @XmlElement(name = "gubun")
        private String gubun;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class OutputData {
        @XmlElement(name = "items")
        private Items items;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Items {
        private String area;
        private String analdate;
        private String mini;
        private String maxi;
        private String meanavg;
        private String std;
        private String d1;
        private String d2;
        private String d3;
        private String d4;
    }
}
