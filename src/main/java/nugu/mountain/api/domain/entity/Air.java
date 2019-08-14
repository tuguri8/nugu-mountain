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
public class Air extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -14238791237843142L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "AREA_CODE")
    private final String areaCode;

    @Column(name = "ITEM_CODE")
    private final String itemCode;

    @Column(name = "AIR_VALUE")
    private final Integer airValue;

    @Column(name = "DATA_TIME")
    private final LocalDateTime dataTime;

    public static class Builder {
        private final String areaCode;
        private final Integer airvalue;
        private final LocalDateTime dateTime;
        private String itemCode = "PM10";

        public Builder(String areaCode, Integer airvalue, LocalDateTime dateTime) {
            this.areaCode = areaCode;
            this.airvalue = airvalue;
            this.dateTime = dateTime;
        }

        public Builder itemCode(String item) {
            itemCode = item;
            return this;
        }

        public Air build() {
            return new Air(this);
        }
    }

    public Air(Builder builder) {
        areaCode = builder.areaCode;
        itemCode = builder.itemCode;
        airValue = builder.airvalue;
        dataTime = builder.dateTime;
    }
}
