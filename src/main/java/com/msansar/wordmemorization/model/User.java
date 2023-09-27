package com.msansar.wordmemorization.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Document("user")
public class User extends BaseEntity{
    private String username;
    private String password;
    private String email;
    @DBRef
    @JsonIgnore
    List<WordGroup> wordGroupList = new ArrayList<>();

    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String id, Date createdAt, Date updatedAt, String username, String password, String email) {
        super(id, createdAt, updatedAt);
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    public List<WordGroup> getWordGroupList() {
        return wordGroupList;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
// TODO: CascadeSave yap