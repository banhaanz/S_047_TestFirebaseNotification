package com.aek.testFirebaseNotification.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class TestRequestM {

    @NotNull(message = "[name] is not null or empty.")
    private String name;

    @NotNull
    @Min(value = 10)
    @Max(value = 50)
    private int age;

    @NotNull
    @Size(min = 10, max = 50)
    String details;

    @NotNull
    @AssertTrue
    boolean workstatus;

    @NotNull
    @Email
    String email;
}
