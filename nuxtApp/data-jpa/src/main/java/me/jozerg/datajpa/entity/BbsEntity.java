package me.jozerg.datajpa.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"bbsId", "bbsTit", "bbsCntn"})
@Table(name = "TB_UHDC_BBS_M")
public class BbsEntity {
    @Id @GeneratedValue
    private Long bbsId;
    private String bbsTit;
    private String bbsCntn;
    private String regUserId;
    private LocalDateTime regDttm;

    public BbsEntity(String bbsTit, String bbsCntn, String regUserId, LocalDateTime regDttm) {
        this.bbsTit = bbsTit;
        this.bbsCntn = bbsCntn;
        this.regUserId = regUserId;
        this.regDttm = regDttm;
    }
}
