package com.aek.testFirebaseNotification.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@NoArgsConstructor
public class AppProperties {

    @Value("${app.message}")
    private String message;

    @Value("${user2.detail.name}")
    private String name;
    @Value("${user2.detail.id}")
    private String id;
    @Value("${user2.detail.age}")
    private int age;
    @Value("${user2.detail.work}")
    private boolean isWork;


}
