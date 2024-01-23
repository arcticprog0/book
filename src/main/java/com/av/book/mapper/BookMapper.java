package com.av.book.mapper;

import com.av.book.dto.BookDto;
import com.av.book.entity.BookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    @Autowired
    private ModelMapper modelMapper;

    public BookEntity toEntity(BookDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, BookEntity.class);
    }

    public BookDto toDto(BookEntity entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, BookDto.class);
    }
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
