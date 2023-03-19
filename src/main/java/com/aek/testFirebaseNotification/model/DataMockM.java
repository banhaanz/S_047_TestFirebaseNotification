package com.aek.testFirebaseNotification.model;

public class DataMockM {
    private String name;
    private String id;
    private int age;
    private boolean isActive;

    private String message;

    public DataMockM(String id, String name, int age, boolean isActive, String message){
        this.name = name;
        this.id = id;
        this.age = age;
        this.isActive = isActive;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
