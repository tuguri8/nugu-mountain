package nugu.mountain.api.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Mountain {
    private static final long serialVersionUID = -14238791237843141L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "MNT_CODE")
    private Long mntCode;

    @Column(name = "MNT_NAME")
    private String mntName;

    @Column(name = "SUB_NAME")
    private String subName;

    @Column(name = "MNT_AREA")
    private String mntArea;

    @Column(name = "AREA_CODE")
    private String areaCode;

    @Column(name = "MNT_HEIGHT")
    private Integer mntHeight;

    @Lob
    @Column(name = "REASON")
    private String reason;

    @Lob
    @Column(name = "OVERVIEW")
    private String overview;

    @Lob
    @Column(name = "DETAILS")
    private String details;

    @Lob
    @Column(name = "TRANSPORT")
    private String transport;

    @Lob
    @Column(name = "TOURISM_INFO")
    private String tourismInfo;

    @Lob
    @Column(name = "ETC_COURSE")
    private String etcCourse;

    @Column(name = "LAT")
    private String lat;

    @Column(name = "LON")
    private String lon;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMntCode() {
        return mntCode;
    }

    public void setMntCode(Long mntCode) {
        this.mntCode = mntCode;
    }

    public String getMntName() {
        return mntName;
    }

    public void setMntName(String mntName) {
        this.mntName = mntName;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getMntArea() {
        return mntArea;
    }

    public void setMntArea(String mntArea) {
        this.mntArea = mntArea;
    }

    public Integer getMntHeight() {
        return mntHeight;
    }

    public void setMntHeight(Integer mntHeight) {
        this.mntHeight = mntHeight;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getTourismInfo() {
        return tourismInfo;
    }

    public void setTourismInfo(String tourismInfo) {
        this.tourismInfo = tourismInfo;
    }

    public String getEtcCourse() {
        return etcCourse;
    }

    public void setEtcCourse(String etcCourse) {
        this.etcCourse = etcCourse;
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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
