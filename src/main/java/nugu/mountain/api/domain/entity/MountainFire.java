package nugu.mountain.api.domain.entity;

import nugu.mountain.api.domain.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class MountainFire extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -14238731237843141L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "AREA_CODE")
    private String areaCode;

    @Column(name = "MEAN_AVG")
    private String meanAvg;

    @Column(name = "GRADE")
    private String grade;

    @Column(name = "ANAL_DATE")
    private LocalDateTime analDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getMeanAvg() {
        return meanAvg;
    }

    public void setMeanAvg(String meanAvg) {
        this.meanAvg = meanAvg;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public LocalDateTime getAnalDate() {
        return analDate;
    }

    public void setAnalDate(LocalDateTime analDate) {
        this.analDate = analDate;
    }
}
