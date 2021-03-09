package coaching.validation;

import java.util.Collection;

/**
 * Supply information about constraint violation
 */
public class Violation {

    private Object invalidValue;
    private Collection<String> messages;
    private String fieldName;

    /**
     * Invalid value of field violating the rules
     *
     * @return Invalid value
     */
    public Object getInvalidValue() {
        return invalidValue;
    }

    public void setInvalidValue(Object invalidValue) {
        this.invalidValue = invalidValue;
    }

    /**
     * List of violation messages. The reason that we return messages is because one field
     * could violate multiple rules
     *
     * @return Violation message declared in rule annotation
     */
    public Collection<String> getMessages() {
        return messages;
    }

    public void setMessages(Collection<String> messages) {
        this.messages = messages;
    }

    /**
     * Field violating the rule
     *
     * @return Field name
     */
    public String getFieldName() {
        return fieldName;
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
