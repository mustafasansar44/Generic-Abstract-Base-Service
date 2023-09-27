package com.msansar.wordmemorization.controller;

import com.msansar.wordmemorization.dto.UserDto;
import com.msansar.wordmemorization.dto.WordGroupDto;
import com.msansar.wordmemorization.model.User;
import com.msansar.wordmemorization.model.WordGroup;
import com.msansar.wordmemorization.service.UserService;
import com.msansar.wordmemorization.service.WordGroupService;
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
@RequestMapping("/api/wordGroup")
public class WordGroupController {
    private final WordGroupService service;

    public WordGroupController(WordGroupService service) {
        this.service = service;
    }

    @GetMapping("/findAll")
    public List<WordGroupDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/findById")
    public WordGroupDto findById(String id){
        return service.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody WordGroup wordGroup){
        service.save(wordGroup);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam String id){
        return service.delete(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody WordGroupDto wordGroupDto){
        return service.update(wordGroupDto.getId(), wordGroupDto);
    }
}
