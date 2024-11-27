package com.xmeme.starter.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.xmeme.starter.data.MemeEntity;

@Repository
public interface MemesRepository extends MongoRepository<MemeEntity, String> {
    List<MemeEntity> findTop100ByOrderByIdDesc();
    boolean existsByNameOrCaptionOrUrl(String name, String caption, String url);
}
