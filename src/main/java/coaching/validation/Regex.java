package coaching.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Regex rule
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Regex {

    /**
     * Violation message
     *
     * @return Message
     */
    String message();

    /**
     * Regular expression
     *
     * @return Expression
     */
    String pattern();
}
