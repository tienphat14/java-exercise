package personal;

/**
 * Exception when having invalid data
 *
 * @author dait
 */
public class InvalidValueException extends RuntimeException {
    public InvalidValueException(String s) {
        super(s);
    }
}
