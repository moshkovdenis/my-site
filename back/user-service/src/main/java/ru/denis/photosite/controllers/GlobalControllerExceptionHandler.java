package ru.denis.photosite.controllers;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import ru.denis.photosite.enums.BadRequest;

@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConversion(ConstraintViolationException exception, WebRequest webRequest) {
        return new ResponseEntity<>(checkRequest(exception, webRequest), HttpStatus.BAD_REQUEST);
    }

    private String checkRequest(ConstraintViolationException exception ,WebRequest webRequest) {
        return webRequest.getDescription(false).contains("create-user")
                ? BadRequest.CREATE_USER.getContent() : exception.getMessage();
    }
}
