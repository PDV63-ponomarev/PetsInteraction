package com.example.contollers;

import com.example.exception.HappinessOverflowException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

public class ErrorResponse {
    // название ошибки
    String error;
    // подробное описание
    String description;

    public ErrorResponse(String error, String description){
        this.error = error;
        this.description = description;
    }

    // геттеры нужны, чтобы Spring Boot мог получить значение полей
    public String getError() {
        return error;
    }

    public String getDescription() {
        return description;
    }

    @ExceptionHandler
    public ErrorResponse handle(final RuntimeException e){
        return new ErrorResponse(
                "Ошибка данных", "Подробное описание, где именно произошла ошибка"
        );
    }

    @ExceptionHandler
    public ResponseEntity<Map<String, Integer>> handleHappiesOverflow(final HappinessOverflowException e){
        return new ResponseEntity<>(
                Map.of("happiessLevel", e.getHappinessLevel()),
                HttpStatus.BAD_REQUEST
                );

    }

}
