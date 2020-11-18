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

        final Iterator<Violation> violations = validator.validate(client).iterator();

        ViolationAssertion.create()
                .expectField("firstName")
                .expectMessage("First name must not be null")
                .expectInvalidValue(client.getFirstName())
                .assertViolation(violations.next());

        ViolationAssertion.create()
                .expectField("lastName")
                .expectMessage("Last name length must be within 1 and 5 characters")
                .expectInvalidValue(client.getLastName())
                .assertViolation(violations.next());
    }

    public static class SingleRuleClient {
        @NotNull(message = "First name must not be null")
        private String firstName;

        @Size(max = 5, message = "Last name length must be within 1 and 5 characters")
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

        ViolationAssertion.create()
                .expectField("firstName")
                .expectMessage("First name length must be within 2 and 5 characters")
                .expectMessage("Digit characters is only allowed")
                .expectInvalidValue(client.getFirstName())
                .assertViolation(violations.next());

        ViolationAssertion.create()
                .expectField("lastName")
                .expectMessage("Last name length must be within 1 and 5 characters")
                .expectMessage("Alphabet characters is only allowed")
                .expectInvalidValue(client.getLastName())
                .assertViolation(violations.next());
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
