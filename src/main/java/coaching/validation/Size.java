package coaching.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Size rule
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Size {

    /**
     * Violation message
     *
     * @return Message
     */
    String message();

    /**
     * Minimum, 1 character as default
     *
     * @return Minimum
     */
    int min() default 1;

    /**
     * Maximum, {@code Integer.MAX_VALUE} as default
     *
     * @return Maximum
     */
    int max() default Integer.MAX_VALUE;
}
