package org.gopi.pwdvalidator.interfaces;

/**
 * This interface defines the 'checked' @link Rule behaviors.
 */
public interface CheckedRule extends Rule {
    /**
     * This method checks if the rule is satisfied.
     * @return boolean
     */
    boolean check(char[] password);
}
