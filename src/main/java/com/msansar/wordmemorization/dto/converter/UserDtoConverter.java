package com.msansar.wordmemorization.dto.converter;


import com.msansar.wordmemorization.dto.UserDto;
import com.msansar.wordmemorization.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDtoConverter implements DtoConverter<User, UserDto>{

    @Override
    public UserDto convertToDto(User entity) {
        return new UserDto(entity.getId(), entity.getCreatedAt(), entity.getUpdatedAt(), entity.getUsername(), entity.getPassword(), entity.getEmail());
    }

    @Override
    public List<UserDto> convertToDtoList(List<User> entities) {
        return entities.stream().map(user -> convertToDto(user)).toList();
    }
}
