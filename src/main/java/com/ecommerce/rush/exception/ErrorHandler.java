package com.ecommerce.rush.exception;

import javax.validation.ConstraintViolationException;

import com.ecommerce.rush.controller.RespostaApi;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RespostaApi tratarErroValidacao(ConstraintViolationException ex){
        return new RespostaApi(ex.getMessage());
    }
    
}
