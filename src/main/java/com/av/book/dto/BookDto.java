package com.av.book.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Модель книги")
public class BookDto {

    @Schema(description = "Id записи в БД")
    private Long id;

    @Schema(description = "Наименование", example = "Книга №1")
    @NotNull
    private String name;

    @Schema(description = "Признак доступности книги", example = "true")
    @NotNull
    private Boolean available;

}
