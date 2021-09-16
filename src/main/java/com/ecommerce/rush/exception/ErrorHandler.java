package com.ecommerce.rush.exception;

import javax.validation.ConstraintViolationException;
import javax.validation.ConstraintViolation;

import com.ecommerce.rush.controller.RespostaApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> tratarErroValidacao(ConstraintViolationException ex){
        Map<String, String> errosMap = new HashMap<>();
        for(ConstraintViolation violation : ex.getConstraintViolations()){
            errosMap.put(violation.getPropertyPath().toString(), violation.getMessage());
        }
        return ResponseEntity.badRequest().body(errosMap);
    }
}
