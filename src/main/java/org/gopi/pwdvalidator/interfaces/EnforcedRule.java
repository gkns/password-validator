package org.gopi.pwdvalidator.interfaces;

/**
 * This interface defines the 'enforced' @link Rule behaviors.
 */
public interface EnforcedRule extends Rule {
    /**
     * This method enforces the rule.
     * @throws Exception
     */
    void enforce(char[] password);
}
