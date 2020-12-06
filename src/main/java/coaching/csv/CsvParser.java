package coaching.csv;

import java.io.Closeable;
import java.util.Iterator;

/**
 * Used for iterating through every lines in the CSV file and close resource
 * to release memory after done processing with records, please refer these
 * links below for detailed documentation of each interfaces
 * - Iterator: https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
 * - Closable: https://docs.oracle.com/javase/8/docs/api/java/io/Closeable.html
 */
public interface CsvParser extends Iterator<CsvLine>, Closeable {
    public void close();
    public boolean hasNext();
    public CsvLine next();
}
