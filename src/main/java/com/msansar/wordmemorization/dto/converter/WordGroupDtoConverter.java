package com.msansar.wordmemorization.dto.converter;

import com.msansar.wordmemorization.dto.WordGroupDto;
import com.msansar.wordmemorization.model.WordGroup;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WordGroupDtoConverter implements DtoConverter<WordGroup, WordGroupDto>{
    @Override
    public WordGroupDto convertToDto(WordGroup entity) {
        return new WordGroupDto(entity.getId(), entity.getUserId(), entity.getForeignWord(), entity.getLocalWord(), entity.isActive());
    }
    @Override
    public List<WordGroupDto> convertToDtoList(List<WordGroup> entities) {
        return entities.stream().map(wordGroup -> convertToDto(wordGroup)).toList();
    }
}
