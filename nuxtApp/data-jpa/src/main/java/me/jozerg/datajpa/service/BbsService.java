package me.jozerg.datajpa.service;

import lombok.RequiredArgsConstructor;
import me.jozerg.datajpa.dto.BbsDto;
import me.jozerg.datajpa.entity.BbsEntity;
import me.jozerg.datajpa.repository.BbsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BbsService {
    private final BbsRepository bbsRepository;

    public List<BbsDto> findAllBbs() {
        List<BbsEntity> findBbsAll = bbsRepository.findAll();

        List<BbsDto> bbsDtoList = findBbsAll.stream()
                .map(bbs -> new BbsDto(bbs))
                .collect(Collectors.toList());

        return bbsDtoList;
    }

    public BbsDto findBbsByBbsId(Long bbsId) {
        BbsEntity bbs = bbsRepository.findById(bbsId).orElse(null);

        return new BbsDto(bbs);
    }

    public BbsEntity saveBbs(BbsEntity bbsEntity) {
        BbsEntity bbs = bbsRepository.save(bbsEntity);

        return bbs;
    }
}
