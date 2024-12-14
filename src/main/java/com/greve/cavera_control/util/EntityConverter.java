package com.greve.cavera_control.util;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class EntityConverter {

    private EntityConverter() {}

    private static final ModelMapper mapper = new ModelMapper();

    public static <D, T> D convertToDTO(T entity, Class<D> dtoClass) {
        return mapper.map(entity, dtoClass);
    }

    public static <D, T> List<D> convertToDTO(List<T> entities, Class<D> dtoClass) {
        return entities.stream() //
                .map(entity -> mapper.map(entity, dtoClass)) //
                .toList();
    }

    public static <D, T> Page<D> convertToDTO(Page<T> entities, Class<D> dtoClass) {
        List<D> dtoList = entities.getContent().stream() //
                .map(entity -> mapper.map(entity, dtoClass)) //
                .toList();

        return new PageImpl<>(dtoList, entities.getPageable(), entities.getTotalElements());
    }

    public static <T, D> T convertToEntity(D dto, Class<T> entityClass) {
        return mapper.map(dto, entityClass);
    }

    public static <T, D> List<T> converToEntity(List<D> dtos, Class<T> entityClass) {
        return dtos.stream() //
                .map(dto -> mapper.map(dto, entityClass)) //
                .toList();
    }

}
