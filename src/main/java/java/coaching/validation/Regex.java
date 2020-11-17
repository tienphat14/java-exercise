package java.coaching.validation;

/**
 * Regex rule
 */
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
