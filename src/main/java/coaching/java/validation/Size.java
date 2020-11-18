package coaching.java.validation;

/**
 * Size rule
 */
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
