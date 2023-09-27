package com.msansar.wordmemorization.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto{

    private String id;
    private Date createdAt;
    private Date updatedAt;
    private String username;
    private String password;
    private String email;
}
