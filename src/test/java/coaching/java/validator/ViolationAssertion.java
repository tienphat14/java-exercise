package coaching.java.validator;

import coaching.java.validation.Violation;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public final class ViolationAssertion {
    private String fieldName;
    private Object invalidValue;
    private final List<String> messages = new ArrayList<>();

    public static ViolationAssertion create() {
        return new ViolationAssertion();
    }

    public ViolationAssertion expectField(String name) {
        this.fieldName = name;
        return this;
    }

    public ViolationAssertion expectInvalidValue(Object value) {
        this.invalidValue = value;
        return this;
    }

    public ViolationAssertion expectMessage(String message) {
        this.messages.add(message);
        return this;
    }

    public void assertViolation(Violation violation) {
        assertEquals(fieldName, violation.getField());
        assertEquals(invalidValue, violation.getInvalidValue());
        assertTrue(messages.containsAll(violation.getMessages()));
    }
}
