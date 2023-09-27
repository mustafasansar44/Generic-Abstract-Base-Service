package com.msansar.wordmemorization.dto.converter;

import com.msansar.wordmemorization.dto.BaseDto;
import com.msansar.wordmemorization.model.BaseEntity;

import java.util.List;

public interface DtoConverter<E extends BaseEntity, D extends BaseDto> {
    public D convertToDto(E entity);
    public List<D> convertToDtoList(List<E> entities);
}
