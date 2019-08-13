package nugu.mountain.api.infrastructure.sk.dto;

import java.util.List;

public class GeocodingResponse {
    private CoordinateInfo coordinateInfo;

    public CoordinateInfo getCoordinateInfo() {
        return coordinateInfo;
    }

    public void setCoordinateInfo(CoordinateInfo coordinateInfo) {
        this.coordinateInfo = coordinateInfo;
    }

    public static class CoordinateInfo {
        private String coordType;
        private String addressFlag;
        private String page;
        private String count;
        private String totalCount;
        List<Coordinate> coordinate;

        public String getCoordType() {
            return coordType;
        }

        public void setCoordType(String coordType) {
            this.coordType = coordType;
        }

        public String getAddressFlag() {
            return addressFlag;
        }

        public void setAddressFlag(String addressFlag) {
            this.addressFlag = addressFlag;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        public List<Coordinate> getCoordinate() {
            return coordinate;
        }

        public void setCoordinate(List<Coordinate> coordinate) {
            this.coordinate = coordinate;
        }
    }

    public static class Coordinate {
        private String matchFlag;
        private String lat;
        private String lon;
        private String latEntr;
        private String lonEntr;
        private String city_do;
        private String gu_gun;
        private String eup_myun;
        private String legalDong;
        private String adminDong;
        private String ri;
        private String bunji;
        private String buildingName;
        private String buildingDong;
        private String newMatchFlag;
        private String newLat;
        private String newLon;
        private String newLatEntr;
        private String newLonEntr;
        private String newRoadName;
        private String newBuildingIndex;
        private String newBuildingName;
        private String newBuildingCateName;
        private String newBuildingDong;
        private String zipcode;
        private String remainder;

        public String getMatchFlag() {
            return matchFlag;
        }

        public void setMatchFlag(String matchFlag) {
            this.matchFlag = matchFlag;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getLatEntr() {
            return latEntr;
        }

        public void setLatEntr(String latEntr) {
            this.latEntr = latEntr;
        }

        public String getLonEntr() {
            return lonEntr;
        }

        public void setLonEntr(String lonEntr) {
            this.lonEntr = lonEntr;
        }

        public String getCity_do() {
            return city_do;
        }

        public void setCity_do(String city_do) {
            this.city_do = city_do;
        }

        public String getGu_gun() {
            return gu_gun;
        }

        public void setGu_gun(String gu_gun) {
            this.gu_gun = gu_gun;
        }

        public String getEup_myun() {
            return eup_myun;
        }

        public void setEup_myun(String eup_myun) {
            this.eup_myun = eup_myun;
        }

        public String getLegalDong() {
            return legalDong;
        }

        public void setLegalDong(String legalDong) {
            this.legalDong = legalDong;
        }

        public String getAdminDong() {
            return adminDong;
        }

        public void setAdminDong(String adminDong) {
            this.adminDong = adminDong;
        }

        public String getRi() {
            return ri;
        }

        public void setRi(String ri) {
            this.ri = ri;
        }

        public String getBunji() {
            return bunji;
        }

        public void setBunji(String bunji) {
            this.bunji = bunji;
        }

        public String getBuildingName() {
            return buildingName;
        }

        public void setBuildingName(String buildingName) {
            this.buildingName = buildingName;
        }

        public String getBuildingDong() {
            return buildingDong;
        }

        public void setBuildingDong(String buildingDong) {
            this.buildingDong = buildingDong;
        }

        public String getNewMatchFlag() {
            return newMatchFlag;
        }

        public void setNewMatchFlag(String newMatchFlag) {
            this.newMatchFlag = newMatchFlag;
        }

        public String getNewLat() {
            return newLat;
        }

        public void setNewLat(String newLat) {
            this.newLat = newLat;
        }

        public String getNewLon() {
            return newLon;
        }

        public void setNewLon(String newLon) {
            this.newLon = newLon;
        }

        public String getNewLatEntr() {
            return newLatEntr;
        }

        public void setNewLatEntr(String newLatEntr) {
            this.newLatEntr = newLatEntr;
        }

        public String getNewLonEntr() {
            return newLonEntr;
        }

        public void setNewLonEntr(String newLonEntr) {
            this.newLonEntr = newLonEntr;
        }

        public String getNewRoadName() {
            return newRoadName;
        }

        public void setNewRoadName(String newRoadName) {
            this.newRoadName = newRoadName;
        }

        public String getNewBuildingIndex() {
            return newBuildingIndex;
        }

        public void setNewBuildingIndex(String newBuildingIndex) {
            this.newBuildingIndex = newBuildingIndex;
        }

        public String getNewBuildingName() {
            return newBuildingName;
        }

        public void setNewBuildingName(String newBuildingName) {
            this.newBuildingName = newBuildingName;
        }

        public String getNewBuildingCateName() {
            return newBuildingCateName;
        }

        public void setNewBuildingCateName(String newBuildingCateName) {
            this.newBuildingCateName = newBuildingCateName;
        }

        public String getNewBuildingDong() {
            return newBuildingDong;
        }

        public void setNewBuildingDong(String newBuildingDong) {
            this.newBuildingDong = newBuildingDong;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getRemainder() {
            return remainder;
        }

        public void setRemainder(String remainder) {
            this.remainder = remainder;
        }
    }
}
