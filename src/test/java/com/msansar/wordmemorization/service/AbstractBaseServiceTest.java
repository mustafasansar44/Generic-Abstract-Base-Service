package com.msansar.wordmemorization.service;

import com.msansar.wordmemorization.dto.UserDto;
import com.msansar.wordmemorization.dto.converter.DtoConverter;
import com.msansar.wordmemorization.dto.converter.UserDtoConverter;
import com.msansar.wordmemorization.exception.CustomNotFoundException;
import com.msansar.wordmemorization.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AbstractBaseServiceTest {

    private MongoRepository<User, String> mongoRepository;
    private DtoConverter dtoConverter;
    private AbstractBaseServiceImplTest abstractBaseService;

    @BeforeEach
    void setUp(){
        mongoRepository = mock(MongoRepository.class);
        dtoConverter = mock(UserDtoConverter.class);
        abstractBaseService = new AbstractBaseServiceImplTest(mongoRepository, dtoConverter);
    }

    private class AbstractBaseServiceImplTest extends AbstractBaseService<User, UserDto>{
        public AbstractBaseServiceImplTest(MongoRepository<User, String> repository, DtoConverter converter) {
            super(repository, converter);
        }
    }

    @Test
    @DisplayName("findById() eğer id mevcutsa UserDto dönmeli ")
    public void testFindById_whenIdExists_shouldReturnUserDto(){
        User user = new User("id", new Date(), new Date(), "username", "password", "email");
        UserDto userDto = new UserDto("id", new Date(), new Date(), "username", "password", "email");

        when(mongoRepository.findById("id")).thenReturn(Optional.of(user));
        when(dtoConverter.convertToDto(user)).thenReturn(userDto);
        when(abstractBaseService.findById("id")).thenReturn(userDto);

        assertEquals("id", abstractBaseService.findById("id").getId());
    }

    @Test
    @DisplayName("findById() eğer id mevcut değilse CustomNotFoundException throw etmeli")
    public void testFindById_whenIdDoesNotExists_shouldReturnCustomNotFoundException(){
        when(mongoRepository.findById("id")).thenReturn(Optional.empty());
        assertThrows(CustomNotFoundException.class, () -> abstractBaseService.findById("id"));
    }

    @Test
    @DisplayName("delete() eğer id mevcutsa silmeli ve bir mesaj döndürmeli")
    public void testDelete_whenIdExists_shouldDeleteUser(){
        User user = new User("id", new Date(), new Date(), "username", "password", "email");
        when(mongoRepository.findById("id")).thenReturn(Optional.of(user));
        assertDoesNotThrow(() -> abstractBaseService.delete("id"));
        // TODO: Mesaj döndürme koşulu da kontrol edilebilir!
    }

    @Test
    @DisplayName("delete() eğer id mevcut değilse CustomNotFoundException throw etmeli")
    public void testDelete_whenIdDoesNotExists_shouldThrowCustomNotFoundException(){
        when(mongoRepository.findById("id")).thenReturn(Optional.empty());
        assertThrows(CustomNotFoundException.class, () -> abstractBaseService.delete("id"));
    }




}