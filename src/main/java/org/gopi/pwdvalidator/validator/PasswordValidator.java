package org.gopi.pwdvalidator.validator;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.gopi.pwdvalidator.interfaces.CheckedRule;
import org.gopi.pwdvalidator.interfaces.EnforcedRule;
import org.gopi.pwdvalidator.interfaces.PasswordValidationStrategy;
import org.gopi.pwdvalidator.interfaces.Rule;
import org.gopi.pwdvalidator.rules.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class PasswordValidator implements PasswordValidationStrategy {
    // Ideally, this should be configurable and injected from a config file.
    public static final int MIN_CHECKED_RULE_THRESHOLD = 3;
    Set<Rule> checkedRules;
    Set<Rule> enforcedRules;

    public PasswordValidator() {
        checkedRules = new HashSet<>();
        enforcedRules = new HashSet<>();
    }

    public PasswordValidator addRule(Rule rule) {
        switch (rule) {
            case EnforcedRule enforcedRule:
                enforcedRules.add(enforcedRule);
                break;
            case CheckedRule checkedRule:
                checkedRules.add(checkedRule);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + rule);
        }
        return this;
    }

    @Override
    public boolean validate(char[] password) {
        enforcedRules.forEach(rule -> rule.apply(password));
        long count = checkedRules.stream().filter(rule -> rule.apply(password)).count();
        return count >= MIN_CHECKED_RULE_THRESHOLD;
    }


    public static void main(String[] args) {
        char password[] = "234234234234".toCharArray();
        PasswordValidator passwordValidator = new PasswordValidator();
        passwordValidator.addRule(new NonNullStrategy())
                .addRule(new MinimumLengthStrategy())
                .addRule(new UpperCaseLetterStrategy())
                .addRule(new LowerCaseLetterStrategy())
                .addRule(new NumericCharacterStrategy());
        System.out.println(passwordValidator.validate(password));

    }
}
