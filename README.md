# password-validator

Verification will fail if any one of the rules mentioned does not pass.
Implement the following rules:
  - password should be larger than 8 chars
  - password should not be null
  - password should have one uppercase letter at least
  - password should have one lowercase letter at least
  - password should have one number at least

Password is OK if at least three of the previous conditions is true
Password is never OK if item 1.d is not true.

To compile and execute the tests:

`./mvnw clean install`

Notes
---
1. Requires JDK 17. (Since it uses a preview feature)
2. To correct style issues run : `./mvnw com.diffplug.spotless:spotless-maven-plugin:apply`
3. The implementation deviates from the requirements slightly, in-that, Only for 'Enforced' Exceptions, an Exception is thrown, otherwise just a message is displayed.
