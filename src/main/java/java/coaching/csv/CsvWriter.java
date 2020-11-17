package java.coaching.csv;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;

/**
 * Used for writing data into a file in CSV format and close
 * external resources after done processing
 * - Closable: https://docs.oracle.com/javase/8/docs/api/java/io/Closeable.html
 */
public interface CsvWriter extends Closeable {

    /**
     * Write one line into a CSV file
     *
     * @param line CSV line
     */
    void write(CsvLine line) throws IOException;

    /**
     * Write multiple lines into a CSV file
     *
     * @param lines Multiple CSV lines
     */
    void write(Collection<CsvLine> lines) throws IOException;
}
