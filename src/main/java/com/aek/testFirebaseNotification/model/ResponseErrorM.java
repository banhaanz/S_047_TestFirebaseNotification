package com.aek.testFirebaseNotification.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseErrorM {
    String title;
    String statusCode;
    String message;
}
