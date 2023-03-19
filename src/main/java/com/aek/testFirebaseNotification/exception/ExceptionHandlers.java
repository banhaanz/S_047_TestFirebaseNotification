package com.aek.testFirebaseNotification.exception;

import com.aek.testFirebaseNotification.model.ResponseErrorM;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler
    public ResponseEntity<ResponseErrorM> validateErrorHandle(ValidateException ex){
        ResponseErrorM responseErrorM = ResponseErrorM.builder()
                .title("Error")
                .statusCode("9999")
                .message(ex.getMessage()).build();
        System.out.println("Error : " + ex.getMessage());
        return ResponseEntity.badRequest().body(responseErrorM);
    }
}
