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

    public ResultSummary getResultSummary() {
        return resultSummary;
    }

    public InputData getInputData() {
        return inputData;
    }

    public OutputData getOutputData() {
        return outputData;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ResultSummary {
        private String totalCnt;

        public String getTotalCnt() {
            return totalCnt;
        }
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

        public String getKeyValue() {
            return keyValue;
        }

        public String getVersion() {
            return version;
        }

        public String getLocalarea() {
            return localarea;
        }

        public String getGubun() {
            return gubun;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class OutputData {
        @XmlElement(name = "items")
        private Items items;

        public Items getItems() {
            return items;
        }
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

        public String getArea() {
            return area;
        }

        public String getAnaldate() {
            return analdate;
        }

        public String getMini() {
            return mini;
        }

        public String getMaxi() {
            return maxi;
        }

        public String getMeanavg() {
            return meanavg;
        }

        public String getStd() {
            return std;
        }

        public String getD1() {
            return d1;
        }

        public String getD2() {
            return d2;
        }

        public String getD3() {
            return d3;
        }

        public String getD4() {
            return d4;
        }
    }
}
