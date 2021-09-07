package com.example.petscareapp.validator;

public class InputErrorHandler {
    String upperCaseChars = "(.*[A-Z].*)";
    String lowerCaseChars = "(.*[a-z].*)";
    String numbers = "(.*[0-9].*)";
    String emailCheck = "^(.+)@(.+)$";
    String passwordError;
    String emailError;

    public String showEmailError(String emailEntered) {
        if (emailEntered.isEmpty()) {
            return emailError = "Please, enter email.";
        }
        if (!emailEntered.matches(emailCheck)) {
            return emailError = "Please, enter a valid email address";
        } else {
            return emailError = "EmailError validation passed:" + emailEntered;
        }
    }

    public String showPasswordError(String passwordEntered, String passwordEnteredToConfirm) {
        if (passwordEntered.isEmpty()) {
            return passwordError = "Password must be not less than 8 characters in length.";
        }
        if (passwordEntered.length() < 8) {
            return passwordError = "Password must be not less than 8 characters in length.";
        }
        if (!passwordEntered.matches(upperCaseChars)) {
            return passwordError = "Password must have at least one uppercase character";
        }
        if (!passwordEntered.matches(lowerCaseChars)) {
            return passwordError = "Password must have at least one lowercase character";
        }
        if (!passwordEntered.matches(numbers)) {
            return passwordError = "Password must have at least one number";
        }
        if (passwordEnteredToConfirm.isEmpty()) {
            return passwordError = "The password conformation does not match";
        }
        if (!passwordEnteredToConfirm.equals(passwordEntered)) {
            return passwordError = "The password conformation does not match";
        }
        else {
                return passwordError = "validation passed";
            }
        }
    }
