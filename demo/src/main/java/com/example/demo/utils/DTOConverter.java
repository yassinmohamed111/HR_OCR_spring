package com.example.demo.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;


public class DTOConverter {
    public static <D, E> E convertToEntity(D dto, Class<E> entityClass) {
        try {
            // Use a default constructor to instantiate the entity
            Constructor<E> constructor = entityClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            E entity = constructor.newInstance();

            // Copy matching fields from DTO to Entity
            for (Field dtoField : dto.getClass().getDeclaredFields()) {
                dtoField.setAccessible(true);
                try {
                    Field entityField = entityClass.getDeclaredField(dtoField.getName());
                    entityField.setAccessible(true);
                    entityField.set(entity, dtoField.get(dto));
                } catch (Exception e) {

                }

            }

            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert DTO to Entity", e);
        }
    }
}
