package me.jozerg.datajpa.dto;

import lombok.Data;
import me.jozerg.datajpa.entity.BbsEntity;

import java.time.LocalDateTime;

@Data
public class BbsDto {
    private Long bbsId;
    private String bbsTit;
    private String bbsCntn;
    private String regUserId;
    private LocalDateTime regDttm;

    public BbsDto(BbsEntity bbs) {
        this.bbsId = bbs.getBbsId();
        this.bbsTit = bbs.getBbsTit();
        this.bbsCntn = bbs.getBbsCntn();
        this.regUserId = bbs.getRegUserId();
        this.regDttm = bbs.getRegDttm();
    }
}
