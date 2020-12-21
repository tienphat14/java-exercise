package coaching.csv;

public class CsvException extends RuntimeException{
    /**
     *  Customize for the CsvException
     *
     * @param msg
     */
    public CsvException(String msg){
        super(msg);
    }

    /**
     * Customize for the CsvException
     *
     * @param msg
     * @param thr
     */

    public CsvException(String msg, Throwable thr){
        super(msg, thr);
    }
}
