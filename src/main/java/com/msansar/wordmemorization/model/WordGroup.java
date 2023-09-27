package com.msansar.wordmemorization.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("wordGroup")
public class WordGroup extends BaseEntity{
    private String userId;
    private String foreignWord;
    private String localWord;
    private boolean isActive;
}
