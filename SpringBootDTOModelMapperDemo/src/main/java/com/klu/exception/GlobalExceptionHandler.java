package com.klu.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
    Map<String,String> errors = new HashMap<>();
    e.getBindingResult().getFieldErrors()
                        .forEach(error -> 
                        errors.put(error.getField(), error.getDefaultMessage()));
    
    return errors;
  }
  
  @ExceptionHandler(Exception.class)
  public String handleInternalServerError(Exception e) {
    return e.getMessage();
  }
}