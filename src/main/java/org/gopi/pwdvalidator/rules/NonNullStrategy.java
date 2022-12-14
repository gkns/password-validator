package org.gopi.pwdvalidator.rules;

import org.gopi.pwdvalidator.interfaces.EnforcedRule;
import org.gopi.pwdvalidator.interfaces.Rule;

public class NonNullStrategy implements Rule, EnforcedRule {
    @Override
    public void enforce(char[] password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null.");
        }
    }

    @Override
    public boolean apply(char[] password) {
        enforce(password);
        return true;
    }
}
