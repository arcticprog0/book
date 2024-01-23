package com.av.book.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ExpectedException extends RuntimeException {

    @Getter
    private final HttpStatus httpStatus;

    public ExpectedException(int status, String message) {
        super(message);
        this.httpStatus = HttpStatus.resolve(status);
    }

    public ExpectedException(EnumException callBackData) {
        super(callBackData.getMessage());
        this.httpStatus = callBackData.getHttpStatus();
    }
}
