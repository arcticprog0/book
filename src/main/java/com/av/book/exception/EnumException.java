package com.av.book.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum EnumException {

    BOOK_NOT_FOUND("Книга c id: %s не найдена."),
    BOOKS_NOT_FOUND("Книги не найдены."),
    BOOK_NOT_AVAILABLE("Книга с id: %s не доступна!"),
    BOOK_DELETE_NOT_AVAILABLE("Нельзя удалить книгу с id: %s, которую еще не вернули."),
    BOOK_ALREADY_AVAILABLE("Книга с id: %s уже сдана, проверьте свою книгу");

    private final String message;
    private final HttpStatus httpStatus;

    EnumException(String message){
        this(message, HttpStatus.NOT_FOUND);
    }

    public String toString(){
        return message;
    }

    public String getFormattedMessage(Object... args) {
        return String.format(message, args);
    }
}
