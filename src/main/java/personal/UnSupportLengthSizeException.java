package personal;

/**
 * Exception when the argument or data having invalid length or size
 *
 * @author dait
 */
public class UnSupportLengthSizeException extends RuntimeException {
    public UnSupportLengthSizeException(String s) {
        super(s);
    }
}
