package com.aek.testFirebaseNotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:user.properties")
public class TestFirebaseNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestFirebaseNotificationApplication.class, args);
	}

}
