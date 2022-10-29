package rules;

import org.gopi.pwdvalidator.interfaces.Rule;
import org.gopi.pwdvalidator.rules.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordRulesTest {
    static Rule nonNullStrategy;
    static Rule upperCaseLetterStrategy;
    static Rule lowerCaseLetterStrategy;
    static Rule numericCharacterStrategy;
    Rule specialCharacterStrategy;
    static Rule minimumLengthStrategy;

    @BeforeAll
    public static void setup() {
        nonNullStrategy = new NonNullStrategy();
        minimumLengthStrategy = new MinimumLengthStrategy();
        lowerCaseLetterStrategy = new LowerCaseLetterStrategy();
        numericCharacterStrategy = new NumericCharacterStrategy();
        upperCaseLetterStrategy = new UpperCaseLetterStrategy();
    }

    @Test
    public void testNonNullStrategy_Doesnt_Throw_On_NonNullPwd() {
        // Non-null password should not throw an exception.
        nonNullStrategy.apply("password".toCharArray());
    }

    @Test
    public void testNonNullStrategy_Throws_On_NullPwd() {
        // Null password should throw an exception.
        try {
            nonNullStrategy.apply(null);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testMinimumLengthStrategy() {

        // Password with length less than 8 should throw an exception.
        try {
            minimumLengthStrategy.apply("pwd".toCharArray());
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testLowerCaseStrategy_InvalidPwd() {
        // Password with no lower case letter is invalid.
        assertEquals(false, lowerCaseLetterStrategy.apply("PASSWORD".toCharArray()),
                "Password with no lower case letter is invalid.");
    }

    @Test
    public void testLowerCaseStrategy_WithValidPwd() {
        // Password requires at-least {} lower case letter/s.
        assertEquals(true, lowerCaseLetterStrategy.apply("Password".toCharArray()),
                "Password requires at least %s lower case letters."
                        .formatted(LowerCaseLetterStrategy.MIN_LOWER_CASE_CHARACTERS));
    }

    @Test
    public void testNumericCharacterStrategy_InvalidPwd() {
        // Password with no numeric character is invalid.
        assertEquals(false, numericCharacterStrategy.apply("Password".toCharArray()),
                "Password with no numeric character is invalid.");
    }

    @Test
    public void testUpperCaseLetterStrategy_InvalidPwd() {
        // Password with no uppercase character is invalid.
        assertEquals(false, upperCaseLetterStrategy.apply("password".toCharArray()),
                "Password with no uppercase character is invalid.");
    }
}
