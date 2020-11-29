package coaching.validator;

import coaching.validation.Violation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public final class ViolationsAssertion {
    private final List<FieldAssertion> expectedFields = new ArrayList<>();

    public static ViolationsAssertion create() {
        return new ViolationsAssertion();
    }

    public FieldAssertion expectField(String fieldName) {
        final FieldAssertion fieldAssertion = new FieldAssertion(fieldName);
        expectedFields.add(fieldAssertion);
        return fieldAssertion;
    }

    public void assertViolations(Iterator<Violation> violations) {
        final Map<String, FieldAssertion> assertedFieldNames = expectedFields.stream()
                .collect(Collectors.toMap(FieldAssertion::getFieldName, field -> field));

        while (violations.hasNext()) {
            final Violation violation = violations.next();
            final String fieldName = violation.getFieldName();

            if (assertedFieldNames.containsKey(fieldName)) {
                assertedFieldNames.get(fieldName).assertField(violation);
                assertedFieldNames.remove(fieldName);
            }
        }

        assertEquals("No violations found for " + assertedFieldNames.values(), 0, assertedFieldNames.size());
    }

    public class FieldAssertion {
        private final String fieldName;
        private final List<String> messages = new ArrayList<>();
        private Object invalidValue;

        public FieldAssertion(String fieldName) {
            this.fieldName = fieldName;
        }

        public FieldAssertion withMessage(String message) {
            messages.add(message);
            return this;
        }

        public FieldAssertion withInvalidValue(Object invalidValue) {
            this.invalidValue = invalidValue;
            return this;
        }

        public ViolationsAssertion and() {
            return ViolationsAssertion.this;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void assertField(Violation violation) {
            assertEquals(invalidValue, violation.getInvalidValue());
            assertTrue("Expected violation messages does not meet the expectation " + messages,
                    violation.getMessages().containsAll(messages));
        }

        @Override
        public String toString() {
            return "FieldAssertion{" +
                    "fieldName='" + fieldName + '\'' +
                    ", messages=" + messages +
                    ", invalidValue=" + invalidValue +
                    '}';
        }
    }
}
