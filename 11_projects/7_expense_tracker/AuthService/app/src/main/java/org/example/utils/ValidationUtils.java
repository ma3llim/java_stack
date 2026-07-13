package org.example.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+=^])(?=\\S+$).{8,20}$";
    private static final Pattern PASSWORDREGEXPATTERN = Pattern.compile(PASSWORD_REGEX);
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern EMAILREGEXPATTERN = Pattern.compile(EMAIL_REGEX);

    public static boolean validateUser(String email, String password) {
        validEmail(email);
        validPassword(password);
        return true;
    }

    private static boolean validPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be blank.");
        }
        Matcher matcher = PASSWORDREGEXPATTERN.matcher(password);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Password must be 8-20 characters long and include an uppercase letter, lowercase letter, number, and special character.");
        }
        return true;
    }

    private static boolean validEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be blank.");
        }
        Matcher matcher = EMAILREGEXPATTERN.matcher(email);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Provided email format is invalid.");
        }

        return true;
    }
}
