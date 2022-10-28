package org.example.pwdvalidator.interfaces;

/**
 * This interface defines the 'enforced' rule behaviors.
 */
public interface EnforcedRule {
    /**
     * This method enforces the rule.
     * @throws Exception
     */
    void enforce();
}
