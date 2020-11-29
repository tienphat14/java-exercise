package coaching.validator;

import coaching.validation.DefaultValidator;
import coaching.validation.NotNull;
import coaching.validation.Regex;
import coaching.validation.Size;
import coaching.validation.Validator;
import coaching.validation.Violation;
import org.junit.Test;

import java.util.Iterator;

/**
 * Required Knowledge
 * - Java basic (conditional statement, loop, ...)
 * - Java Annotation
 * - Java Reflection API
 * - OOP principles (Object-Oriented Programming Principles)
 * <p>
 * Requirements
 * - Make sure your code stay consistent
 * - Easily to maintain and highly extensible is a plus
 * - Well documented code
 * - Could handle a new rule with minimal code-change effort
 */
public class DefaultValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenValidate_NullValidatedObject_ThenReject() {
        new DefaultValidator().validate(null);
    }

    /*
     *
     * Testing validator with model having only one rule for each fields
     *
     */

    @Test
    public void whenValidate_FieldHavingSingleRule_ThenReturnViolation() {
        final Validator validator = new DefaultValidator();
        final SingleRuleClient client = new SingleRuleClient();
        client.setFirstName(null);
        client.setLastName("more-than-5-characters");
        client.setAge(15);

        final Iterator<Violation> violations = validator.validate(client).iterator();

        ViolationsAssertion.create()
                .expectField("firstName")
                    .withMessage("First name must not be null")
                    .withInvalidValue(client.getFirstName())
                .and().expectField("lastName")
                    .withMessage("Last name length must be within 1 and 5 characters")
                    .withInvalidValue(client.getLastName())
                .and().expectField("age")
                    .withMessage("Age must be within 18 and 80 years old")
                    .withInvalidValue(client.getAge())
                .and().assertViolations(violations);
    }

    public static class SingleRuleClient {
        @NotNull(message = "First name must not be null")
        private String firstName;

        @Size(max = 5, message = "Last name length must be within 1 and 5 characters")
        private String lastName;

        @Size(min = 18, max = 80, message = "Age must be within 18 and 80 years old")
        private Integer age;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    /*
     *
     * Testing validator with model having multiple rules for each fields
     *
     */

    @Test
    public void whenValidate_FieldHavingMultipleRules_ThenReturnViolation() {
        final Validator validator = new DefaultValidator();
        final MultipleRuleClient client = new MultipleRuleClient();
        client.setFirstName("random123456");
        client.setLastName("654321random");

        final Iterator<Violation> violations = validator.validate(client).iterator();

        ViolationsAssertion.create()
                .expectField("firstName")
                    .withMessage("First name length must be within 2 and 5 characters")
                    .withMessage("Digit characters is only allowed")
                    .withInvalidValue(client.getFirstName())
                .and().expectField("lastName")
                    .withMessage("Last name length must be within 1 and 5 characters")
                    .withMessage("Alphabet characters is only allowed")
                    .withInvalidValue(client.getLastName())
                .and().assertViolations(violations);
    }

    public static class MultipleRuleClient {
        @Size(min = 2, max = 5, message = "First name length must be within 2 and 5 characters")
        @Regex(pattern = "\\d*", message = "Digit characters is only allowed")
        private String firstName;

        @Size(max = 5, message = "Last name length must be within 1 and 5 characters")
        @Regex(pattern = "[a-zA-Z]*", message = "Alphabet characters is only allowed")
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}
