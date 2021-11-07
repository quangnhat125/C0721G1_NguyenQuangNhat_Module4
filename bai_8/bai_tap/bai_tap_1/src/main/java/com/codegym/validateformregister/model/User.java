package com.codegym.validateformregister.model;

import javax.validation.constraints.*;

public class User {
    @NotBlank(message = "First Name can't be empty!")
    @Size(min = 5, max = 45, message = "First Name must be in 5 to 45 characters!")
    private String firstName;
    @NotBlank(message = "First Name can't be empty!")
    @Size(min = 5, max = 45, message = "Last Name must be in 5 to 45 characters!")
    private String lastName;
    @Pattern(regexp = "^[0-9\\-\\+]{9,15}$", message = "Please enter correct format!")
    private String phoneNumber;
    @Min(value = 18, message = "Age must be greater than 18!")
    private int age;
    @Email(message = "Please enter correct format!")
    private String email;

    public User() {
    }

    public User(@NotBlank(message = "First Name can't be empty!")
                @Size(min = 5, max = 45, message = "First Name must be in 5 to 45 characters!") String firstName,
                @NotBlank(message = "First Name can't be empty!")
                @Size(min = 5, max = 45, message = "Last Name must be in 5 to 45 characters!") String lastName,
                @Pattern(regexp = "^[0-9\\-\\+]{9,15}$", message = "Please enter correct format!") String phoneNumber,
                @Min(value = 18, message = "Age must be greater than 18!") int age,
                @Email(message = "Please enter correct format!") String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
