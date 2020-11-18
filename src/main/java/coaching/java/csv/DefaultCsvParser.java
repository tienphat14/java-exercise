package coaching.java.csv;

import java.io.File;
import java.io.IOException;

/**
 * TODO Implement CSV parsing logic here
 */
public class DefaultCsvParser implements CsvParser {

    /**
     * Initialize parser
     *
     * @param file         CSV file
     * @param parserConfig Configuration
     */
    public DefaultCsvParser(File file, CsvFileConfig parserConfig) {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    /**
     * {@inheritDoc}
     *
     * @throws IOException
     */
    @Override
    public void close() {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public CsvLine next() {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }
}
