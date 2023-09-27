package com.msansar.wordmemorization.controller;

import com.msansar.wordmemorization.dto.UserDto;
import com.msansar.wordmemorization.model.User;
import com.msansar.wordmemorization.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/findAll")
    public List<UserDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/findById")
    public UserDto findById(String id){
        return service.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        service.save(user);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam String id){
        return service.delete(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody UserDto userDto){
        return service.update(userDto.getId(), userDto);
    }
}
