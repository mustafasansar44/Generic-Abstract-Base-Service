package com.msansar.wordmemorization.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordGroupDto extends BaseDto{
    private String id;
    private String userId;
    private String foreignWord;
    private String localWord;
    private boolean isActive;
}
