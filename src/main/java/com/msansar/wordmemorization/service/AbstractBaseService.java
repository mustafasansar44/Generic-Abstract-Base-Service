package com.msansar.wordmemorization.service;


import com.msansar.wordmemorization.dto.BaseDto;
import com.msansar.wordmemorization.dto.converter.DtoConverter;
import com.msansar.wordmemorization.exception.CustomNotFoundException;
import com.msansar.wordmemorization.model.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;


public class AbstractBaseService<E extends BaseEntity, D extends BaseDto> {
    private final MongoRepository<E, String> repository;
    private final DtoConverter<E, D> converter;
    public AbstractBaseService(MongoRepository<E, String> repository, DtoConverter<E, D> converter) {
        this.repository = repository;
        this.converter = converter;
    }


    public List<D> findAll(){
        return converter.convertToDtoList(repository.findAll());
    }
    public String save(E entity){
        repository.save(entity);
        return "Veri Kaydedildi!";
    }
    public String delete(String id){
        repository.deleteById(getByIdToEntity(id).getId());
        return "Veri Silindi!";
    }
    public D findById(String id){
        return converter.convertToDto(getByIdToEntity(id));
    }

    /**
     * Verilen id ve entityDto parametresine göre önce entity'i bulur daha sonra entityDto ile entity'nin set metodlarına bakar.
     * Eğer aynı olan varsa ona göre entityDto'daki değeri entity'e aktarır.
     * @return
     */
    public String update(String id, D entityDto){
        E entity = getByIdToEntity(id);
        List<Method> entityDtoSetMethods = Arrays.stream(entityDto.getClass().getMethods())
                .filter(method -> method.getName().startsWith("set")).toList();

        entityDtoSetMethods.forEach(setMethod -> {
            String fieldName = setMethod.getName().substring(3); // "set" sonrası field ismi
            try {
                // Burada her ikisinde de ortak olan metodlara göre dto değerlerini entity'e setler.
                Method dtoGetMethod = entityDto.getClass().getMethod("get" + fieldName);
                Object value = dtoGetMethod.invoke(entityDto); // entityDto'dan değeri al
                // Getter ve Setter'a göre işlem yaptığımız için, setleyeceğimiz verinin tipini get metodundan alıyorum. dtoGetMethod.getReturnType()
                Method entitySetMethod = entity.getClass().getMethod("set" + fieldName, dtoGetMethod.getReturnType());
                entitySetMethod.invoke(entity, value);
            } catch (Exception e) {
                e.printStackTrace(); // TODO: BURAYI SONRA DÜZELT
            }
        });
        repository.save(entity);
        return "Veri Güncellendi!";
    }
    private E getByIdToEntity(String id){
        return repository.findById(id).orElseThrow(
                () -> new CustomNotFoundException("Veri bulunamadı!", new RuntimeException())
        );
    }
}

