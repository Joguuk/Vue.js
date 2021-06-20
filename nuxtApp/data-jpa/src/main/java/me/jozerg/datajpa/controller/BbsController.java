package me.jozerg.datajpa.controller;

import lombok.RequiredArgsConstructor;
import me.jozerg.datajpa.dto.BbsDto;
import me.jozerg.datajpa.service.BbsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class BbsController {

    private final BbsService bbsService;

    @GetMapping
    public List<BbsDto> findAllBbs() {
        return bbsService.findAllBbs();
    }

    @GetMapping("/{bbsId}")
    public BbsDto findBbsByBbsId(
            @PathVariable(name = "bbsId") Long bbsId) {
        return bbsService.findBbsByBbsId(bbsId);
    }
}
