package coaching.validation;

import java.util.Collection;

/**
 * TODO Your implementation goes here
 */
public class DefaultValidator implements Validator {

    /**
     * {@inheritDoc}
     *
     * @param data Input data
     * @return
     */
    @Override
    public Collection<Violation> validate(Object data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        return null;
    }
}
