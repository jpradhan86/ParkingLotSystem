package com.jitendra;

public class Vehicle {
    private String registrationNumber;
    private String color;
    public Vehicle(String registrationNumber, String color) {
        setRegistrationNumber(registrationNumber);
        setColor(color);
    }   
    private void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }   
    public String getRegistrationNumber() {
        return registrationNumber;
    }   
    private void setColor(String color) {
        this.color = color;
    }   
    public String getColor() {
        return color;
    }   
    public String toString() {
        return getRegistrationNumber() + "\t" + getColor(); 
    }   
}