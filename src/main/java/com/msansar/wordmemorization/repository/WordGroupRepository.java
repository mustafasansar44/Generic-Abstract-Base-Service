package com.msansar.wordmemorization.repository;

import com.msansar.wordmemorization.model.WordGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WordGroupRepository extends GlobalRepository<WordGroup, String> {
}
