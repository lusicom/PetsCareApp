package com.example.petscareapp.validator;

import android.util.Patterns;

import java.util.regex.Pattern;

public class BaseValidator {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=.*[a-z])" +
                    "(?=.*[A-Z])" +
                    ".{8,}" +
                    "$");

    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+");


    public boolean validateEnteredPassword(String passwordEntered) {
        if (passwordEntered.isEmpty()) {
            return false;
        } else {
            return PASSWORD_PATTERN.matcher(passwordEntered).matches();
        }
    }

    public boolean validateEnteredAndConfirmedPassword(String passwordEntered, String passwordEnteredToConfirm) {
        return validateEnteredPassword(passwordEntered) && passwordEntered.equals(passwordEnteredToConfirm);
    }

    public boolean validateEnteredEmail(String emailEntered) {
        if (emailEntered.isEmpty()) {
            return false;
        } else return EMAIL_ADDRESS_PATTERN.matcher(emailEntered).matches();

    }
}





