package org.gopi.pwdvalidator.rules;

import org.gopi.pwdvalidator.interfaces.CheckedRule;
import org.gopi.pwdvalidator.interfaces.Rule;

public class NumericCharacterStrategy implements Rule, CheckedRule {
    // Ideally, this should be configurable and injected from a config file.
    public static final int MIN_NUMERIC_CHARACTERS = 1;

    @Override
    public boolean apply(char[] password) {
        int count = 0;
        for (char c : password) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count >= MIN_NUMERIC_CHARACTERS;
    }

    @Override
    public boolean check(char[] password) {
        return apply(password);
    }
}
