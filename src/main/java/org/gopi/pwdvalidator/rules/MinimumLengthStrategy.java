package org.gopi.pwdvalidator.rules;

import org.gopi.pwdvalidator.interfaces.EnforcedRule;
import org.gopi.pwdvalidator.interfaces.Rule;

public class MinimumLengthStrategy implements Rule, EnforcedRule {
    // Ideally, this should be configurable and injected from a config file.

    public static final int PWD_MINIMUM_LENGTH = 8;

    @Override
    public void enforce(char[] password) {
        if (password != null && password.length < PWD_MINIMUM_LENGTH) {
            throw new IllegalArgumentException("Password must be at least "
                    + PWD_MINIMUM_LENGTH + " characters long.");
        }
    }

    @Override
    public boolean apply(char[] password) {
        enforce(password);
        return true;
    }
}
