package com.av.book.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Schema(description = "Тело ошибки")
public class ErrorBody {

    @Schema(description = "Описание ошибки")
    String message;
}
