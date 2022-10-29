package org.gopi.pwdvalidator.interfaces;

/**
 * This interface defines the PasswordValidator behaviors.
 */
public interface PasswordValidationStrategy {
    /**
     * This method adds a @link Rule to the validator.
     * @param rule
     */
    void addRule(Rule rule);

    /**
     * This method validates the password.
     * @param password
     * @return boolean
     */
    boolean validate(char[] password);
}
