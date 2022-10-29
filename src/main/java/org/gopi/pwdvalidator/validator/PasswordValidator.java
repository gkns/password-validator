package org.gopi.pwdvalidator.validator;

import lombok.*;
import org.gopi.pwdvalidator.interfaces.Rule;
import org.gopi.pwdvalidator.rules.*;
import org.gopi.pwdvalidator.rules.NonNullStrategy;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PasswordValidator {
    Map<Class, Rule> rules;
    PasswordValidator(){
        rules = new HashMap<>();
    }
    public void addRule(Rule rule){
        rules.put(rule.getClass(), rule);
    }
    public boolean validate(char[] password){
        for (Rule rule : rules.values()) {
            if (!rule.apply(password)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       char password[] = "Gopi@123".toCharArray();
         PasswordValidator passwordValidator = new PasswordValidatorBuilder()
                .addRule(new NonNullStrategy())
                .addRule(new MinimumLengthStrategy())
                .addRule(new UpperCaseLetterStrategy())
                .addRule(new LowerCaseLetterStrategy())
                .addRule(new NumericCharacterStrategy())
                .build();
    }
}
