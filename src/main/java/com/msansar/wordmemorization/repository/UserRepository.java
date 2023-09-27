package com.msansar.wordmemorization.repository;

import com.msansar.wordmemorization.model.User;
import org.springframework.context.annotation.Primary;

@Primary
public interface UserRepository extends GlobalRepository<User, String>{

}
