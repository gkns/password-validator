package org.gopi.pwdvalidator.interfaces;

/**
 * This interface defines the rule behaviors.
 */
public interface Rule {
    /**
     * This method executes enforce() or check() based on the rule type.
     * @return boolean
     * @throws Exception
     */
    boolean apply(char[] password);
}
