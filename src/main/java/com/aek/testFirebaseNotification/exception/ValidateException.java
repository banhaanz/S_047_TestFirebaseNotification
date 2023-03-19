package com.aek.testFirebaseNotification.exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

public class ValidateException extends RuntimeException{
    private final BindingResult errors;

    public ValidateException(BindingResult errors) {
        this.errors = errors;
    }

    public List<String> getMessages() {
        return getValidationMessage(this.errors);
    }

    private List<String> getValidationMessage(BindingResult error){
        return error.getAllErrors().stream()
                .map(this::getValidationMessage)
                .collect(Collectors.toList());
    }

    private String getValidationMessage(ObjectError error){
        if(error instanceof FieldError){
            FieldError fieldError = (FieldError) error;
            String className = fieldError.getObjectName();
            String property = fieldError.getField();
            Object invalidValue = fieldError.getRejectedValue();
            String message = fieldError.getDefaultMessage();
            return String.format("[%s] %s, but found %s",property,message,invalidValue);
        }
        return String.format("%s :%s",error.getObjectName(),error.getDefaultMessage());
    }

    @Override
    public String getMessage() {
        return this.getMessages().toString();
    }
}
