package com.msansar.wordmemorization.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface GlobalRepository<T, ID> extends MongoRepository<T, ID> {
}
