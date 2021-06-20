package me.jozerg.datajpa.repository;

import me.jozerg.datajpa.entity.BbsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BbsRepository extends JpaRepository<BbsEntity, Long> {
}
