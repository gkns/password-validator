package org.gopi.pwdvalidator.interfaces;

import org.gopi.pwdvalidator.validator.PasswordValidator;

/**
 * This interface defines the PasswordValidator behaviors.
 */
public interface PasswordValidationStrategy {
    /**
     * This method adds a @link Rule to the validator.
     *
     * @param rule
     * @return
     */
    PasswordValidator addRule(Rule rule);

    /**
     * This method validates the password.
     * @param password
     * @return int indicating the number of rules that passed.
     */
    boolean validate(char[] password);
}
