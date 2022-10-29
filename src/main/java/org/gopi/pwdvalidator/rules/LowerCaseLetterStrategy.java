package org.gopi.pwdvalidator.rules;

import org.gopi.pwdvalidator.interfaces.CheckedRule;
import org.gopi.pwdvalidator.interfaces.Rule;

public class LowerCaseLetterStrategy implements Rule, CheckedRule {
    // Ideally, this should be configurable and injected from a config file.
    public static int MIN_LOWER_CASE_CHARACTERS = 1;
    @Override
    public boolean apply(char[] password) {
        int count = 0;
        for (char c : password) {
            if (Character.isLowerCase(c)) {
                count++;
            }
        }
        return count >= MIN_LOWER_CASE_CHARACTERS;
    }

    @Override
    public boolean check(char[] password) {
        return apply(password);
    }
}
