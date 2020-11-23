package coaching.validation;

import java.util.Collection;

/**
 * Supply information about constraint violation
 */
public class Violation {

    /**
     * Invalid value of field violating the rules
     *
     * @return Invalid value
     */
    public String getInvalidValue() {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    /**
     * List of violation messages. The reason that we return messages is because one field
     * could violate multiple rules
     *
     * @return Violation message declared in rule annotation
     */
    public Collection<String> getMessages() {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    /**
     * Field violating the rule
     *
     * @return Field name
     */
    public String getFieldName() {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }
}
