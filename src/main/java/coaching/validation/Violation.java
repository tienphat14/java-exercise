package coaching.validation;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Supply information about constraint violation
 */
public class Violation {
    Object invalidValue;
    Collection<String> messages = new ArrayList<>();
    String fieldName;

    /**
     * Invalid value of field violating the rules
     *
     * @return Invalid value
     */
    public Object getInvalidValue() {
        return this.invalidValue;
    }

    /**
     * List of violation messages. The reason that we return messages is because one field
     * could violate multiple rules
     *
     * @return Violation message declared in rule annotation
     */
    public Collection<String> getMessages() {
        return this.messages;
    }

    /**
     * Field violating the rule
     *
     * @return Field name
     */
    public String getFieldName() {
        return this.fieldName;
    }

    public void setInvalidValue(Object invalidValue) {
        this.invalidValue = invalidValue;
    }

    public void setMessages(String message) {
        this.messages.add(message);
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "Violation{" +
                "fieldName: '" + getFieldName() + "', " +
                "invalidValue: '" + getInvalidValue() + "', " +
                "messages: '" + getMessages() + "'" +
                "}";
    }
}
