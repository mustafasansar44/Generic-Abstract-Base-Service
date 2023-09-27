package com.msansar.wordmemorization.service;


import com.msansar.wordmemorization.dto.UserDto;
import com.msansar.wordmemorization.dto.converter.DtoConverter;
import com.msansar.wordmemorization.dto.converter.UserDtoConverter;
import com.msansar.wordmemorization.model.User;
import com.msansar.wordmemorization.repository.UserRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService extends AbstractBaseService<User, UserDto>{

    public UserService(UserRepository repository, UserDtoConverter converter) {
        super(repository, converter);
    }

}
