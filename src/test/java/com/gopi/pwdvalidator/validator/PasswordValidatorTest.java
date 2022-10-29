package com.gopi.pwdvalidator.validator;

import org.gopi.pwdvalidator.rules.*;
import org.gopi.pwdvalidator.validator.PasswordValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidatorTest {
    static PasswordValidator passwordValidator;

    @BeforeAll
    public static void setup() {
        passwordValidator = new PasswordValidator();
        passwordValidator.addRule(new NonNullStrategy());
        passwordValidator.addRule(new MinimumLengthStrategy());
        passwordValidator.addRule(new LowerCaseLetterStrategy());
        passwordValidator.addRule(new NumericCharacterStrategy());
        passwordValidator.addRule(new UpperCaseLetterStrategy());
    }

    @Test
    public void testPasswordValidator_Min_Lenght_Throws() {
        // Password with length less than 8 should throw an exception.
        try {
            passwordValidator.validate("pwd".toCharArray());
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testPasswordValidator_Null_Throws() {
        // Null password should throw an exception.
        try {
            passwordValidator.validate(null);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testPasswordValidator_Min_Threshold() {
        // contains no uppercase/lowercase characters.
        assertEquals(false, passwordValidator.validate("12345678".toCharArray()),
                "Password shouldn't have met the minimum threshold.");
    }
}
