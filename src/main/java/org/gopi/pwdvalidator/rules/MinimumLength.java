package org.gopi.pwdvalidator.rules;

import org.gopi.pwdvalidator.interfaces.EnforcedRule;
import org.gopi.pwdvalidator.interfaces.Rule;

public class MinimumLength implements Rule, EnforcedRule {
    public static final int MINIMUM_LENGTH = 8;

    @Override
    public void enforce(char[] password) {
        if (password.length < MINIMUM_LENGTH) {
            throw new IllegalArgumentException("Password must be at least "
                    + MINIMUM_LENGTH + " characters long.");
        }
    }

    @Override
    public boolean apply(char[] password) {
        enforce(password);
        return true;
    }
}
