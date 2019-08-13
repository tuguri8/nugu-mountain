package nugu.mountain.api.infrastructure.airkorea;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class AirkoreaResponse {
    @XmlElement(name = "header")
    private Header header;
    @XmlElement(name = "body")
    private Body body;

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
        private Item item;

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Item {
        @XmlElement(name = "dataTime")
        private String dataTime;
        @XmlElement(name = "itemCode")
        private String itemCode;
        @XmlElement(name = "dataGubun")
        private String dataGubun;
        @XmlElement(name = "seoul")
        private String seoul;
        @XmlElement(name = "busan")
        private String busan;
        @XmlElement(name = "daegu")
        private String daegu;
        @XmlElement(name = "incheon")
        private String incheon;
        @XmlElement(name = "gwangju")
        private String gwangju;
        @XmlElement(name = "daejeon")
        private String daejeon;
        @XmlElement(name = "ulsan")
        private String ulsan;
        @XmlElement(name = "gyeonggi")
        private String gyeonggi;
        @XmlElement(name = "gangwon")
        private String gangwon;
        @XmlElement(name = "chungbuk")
        private String chungbuk;
        @XmlElement(name = "chungnam")
        private String chungnam;
        @XmlElement(name = "jeonbuk")
        private String jeonbuk;
        @XmlElement(name = "jeonnam")
        private String jeonnam;
        @XmlElement(name = "gyeongbuk")
        private String gyeongbuk;
        @XmlElement(name = "gyeongnam")
        private String gyeongnam;
        @XmlElement(name = "jeju")
        private String jeju;
        @XmlElement(name = "sejong")
        private String sejong;

        public String getDataTime() {
            return dataTime;
        }

        public String getItemCode() {
            return itemCode;
        }

        public String getDataGubun() {
            return dataGubun;
        }

        public String getSeoul() {
            return seoul;
        }

        public String getBusan() {
            return busan;
        }

        public String getDaegu() {
            return daegu;
        }

        public String getIncheon() {
            return incheon;
        }

        public String getGwangju() {
            return gwangju;
        }

        public String getDaejeon() {
            return daejeon;
        }

        public String getUlsan() {
            return ulsan;
        }

        public String getGyeonggi() {
            return gyeonggi;
        }

        public String getGangwon() {
            return gangwon;
        }

        public String getChungbuk() {
            return chungbuk;
        }

        public String getChungnam() {
            return chungnam;
        }

        public String getJeonbuk() {
            return jeonbuk;
        }

        public String getJeonnam() {
            return jeonnam;
        }

        public String getGyeongbuk() {
            return gyeongbuk;
        }

        public String getGyeongnam() {
            return gyeongnam;
        }

        public String getJeju() {
            return jeju;
        }

        public String getSejong() {
            return sejong;
        }
    }
}
