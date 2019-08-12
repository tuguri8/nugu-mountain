package nugu.mountain.api.infrastructure.mountain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class MountainResponse {
    @XmlElement(name = "header")
    private Header header;
    @XmlElement(name = "body")
    private Body body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Header {
        @XmlElement(name = "resultCode")
        private String resultCode;
        @XmlElement(name = "resultMsg")
        private String resultMsg;

        public String getResultCode() {
            return resultCode;
        }

        public void setResultCode(String resultCode) {
            this.resultCode = resultCode;
        }

        public String getResultMsg() {
            return resultMsg;
        }

        public void setResultMsg(String resultMsg) {
            this.resultMsg = resultMsg;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Body {
        @XmlElement(name = "items")
        private Items items;
        @XmlElement(name = "numOfRows")
        private String numOfRows;
        @XmlElement(name = "pageNo")
        private String pageNo;
        @XmlElement(name = "totalCount")
        private String totalCount;

        public Items getItems() {
            return items;
        }

        public void setItems(Items items) {
            this.items = items;
        }

        public String getNumOfRows() {
            return numOfRows;
        }

        public void setNumOfRows(String numOfRows) {
            this.numOfRows = numOfRows;
        }

        public String getPageNo() {
            return pageNo;
        }

        public void setPageNo(String pageNo) {
            this.pageNo = pageNo;
        }

        public String getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Items {
        @XmlElement(name = "item")
        private List<Item> item;

        public List<Item> getItem() {
            return item;
        }

        public void setItem(List<Item> item) {
            this.item = item;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Item {
        @XmlElement(name = "aeatreason")
        private String aeatreason;
        @XmlElement(name = "areanm")
        private String areanm;
        @XmlElement(name = "details")
        private String details;
        @XmlElement(name = "etccourse")
        private String etccourse;
        @XmlElement(name = "flashurl")
        private String flashurl;
        @XmlElement(name = "mntheight")
        private String mntheight;
        @XmlElement(name = "mntncd")
        private String mntncd;
        @XmlElement(name = "mntnm")
        private String mntnm;
        @XmlElement(name = "overview")
        private String overview;
        @XmlElement(name = "subnm")
        private String subnm;
        @XmlElement(name = "tourisminf")
        private String tourisminf;
        @XmlElement(name = "transport")
        private String transport;
        @XmlElement(name = "videourl")
        private String videourl;

        public String getAeatreason() {
            return aeatreason;
        }

        public void setAeatreason(String aeatreason) {
            this.aeatreason = aeatreason;
        }

        public String getAreanm() {
            return areanm;
        }

        public void setAreanm(String areanm) {
            this.areanm = areanm;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public String getEtccourse() {
            return etccourse;
        }

        public void setEtccourse(String etccourse) {
            this.etccourse = etccourse;
        }

        public String getFlashurl() {
            return flashurl;
        }

        public void setFlashurl(String flashurl) {
            this.flashurl = flashurl;
        }

        public String getMntheight() {
            return mntheight;
        }

        public void setMntheight(String mntheight) {
            this.mntheight = mntheight;
        }

        public String getMntncd() {
            return mntncd;
        }

        public void setMntncd(String mntncd) {
            this.mntncd = mntncd;
        }

        public String getMntnm() {
            return mntnm;
        }

        public void setMntnm(String mntnm) {
            this.mntnm = mntnm;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getSubnm() {
            return subnm;
        }

        public void setSubnm(String subnm) {
            this.subnm = subnm;
        }

        public String getTourisminf() {
            return tourisminf;
        }

        public void setTourisminf(String tourisminf) {
            this.tourisminf = tourisminf;
        }

        public String getTransport() {
            return transport;
        }

        public void setTransport(String transport) {
            this.transport = transport;
        }

        public String getVideourl() {
            return videourl;
        }

        public void setVideourl(String videourl) {
            this.videourl = videourl;
        }
    }
}
