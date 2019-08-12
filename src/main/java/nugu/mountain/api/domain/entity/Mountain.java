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

    @Column(name = "MNT_HEIGHT")
    private Integer mntHeight;

    @Column(name = "MNT_AREA")
    private String mntArea;

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

}
