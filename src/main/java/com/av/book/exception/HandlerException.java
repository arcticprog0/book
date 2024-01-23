package com.av.book.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class HandlerException {

    @ExceptionHandler
    public ResponseEntity<ErrorBody> handleException(ExpectedException ex) {

        String message = ex.getMessage();

        log.warn(message);

        return new ResponseEntity<>(new ErrorBody(message), ex.getHttpStatus());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler
    public ErrorBody handleException(Exception ex) {

        String message = ex.getMessage();

        if(ex instanceof ExpectedException) {
            log.warn(message);
        } else {
            log.error(message, ex);
        }

        return new ErrorBody(message);
    }
}
