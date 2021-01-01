package coaching.validation;

import java.util.Collection;

/**
 * Validate input data with annotation-based approach
 */
public interface Validator {

    /**
     * Validate data
     *
     * @param data Input data
     * @return Collection of violation instances
     */
    Collection<Violation> validate(Object data);
}
