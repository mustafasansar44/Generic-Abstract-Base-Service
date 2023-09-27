package com.msansar.wordmemorization.service;


import com.msansar.wordmemorization.dto.WordGroupDto;
import com.msansar.wordmemorization.dto.converter.WordGroupDtoConverter;
import com.msansar.wordmemorization.model.WordGroup;
import com.msansar.wordmemorization.repository.WordGroupRepository;
import org.springframework.stereotype.Service;

@Service
public class WordGroupService extends AbstractBaseService<WordGroup, WordGroupDto>{
    public WordGroupService(WordGroupRepository repository, WordGroupDtoConverter converter) {
        super(repository, converter);
    }
}
