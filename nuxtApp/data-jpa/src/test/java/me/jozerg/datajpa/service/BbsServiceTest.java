package me.jozerg.datajpa.service;

import me.jozerg.datajpa.dto.BbsDto;
import me.jozerg.datajpa.entity.BbsEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class BbsServiceTest {
    @Autowired BbsService bbsService;

    @Test
    public void bbsTest() {
        List<BbsDto> allBbs = bbsService.findAllBbs();

        for (BbsDto allBb : allBbs) {
            System.out.println("allBb = " + allBb);
        }
    }

    @Test
    public void bbsByIdTest() {
        BbsDto bbsByBbsId = bbsService.findBbsByBbsId(4L);

        System.out.println("bbsByBbsId = " + bbsByBbsId);
    }

    @Test
    public void createBbsData() {
        BbsEntity bbsEntity1 = new BbsEntity("1", "1", "jozerg", LocalDateTime.now());
        BbsEntity bbsEntity2 = new BbsEntity("2", "2", "jozerg", LocalDateTime.now());
        BbsEntity bbsEntity3 = new BbsEntity("3", "3", "jozerg", LocalDateTime.now());
        BbsEntity bbsEntity4 = new BbsEntity("4", "4", "jozerg", LocalDateTime.now());
        BbsEntity bbsEntity5 = new BbsEntity("5", "5", "jozerg", LocalDateTime.now());

        bbsService.saveBbs(bbsEntity1);
        bbsService.saveBbs(bbsEntity2);
        bbsService.saveBbs(bbsEntity3);
        bbsService.saveBbs(bbsEntity4);
        bbsService.saveBbs(bbsEntity5);
    }
}