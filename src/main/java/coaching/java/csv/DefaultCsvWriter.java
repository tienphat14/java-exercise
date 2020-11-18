package coaching.java.csv;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * TODO Implement CSV writing logic here
 */
public class DefaultCsvWriter implements CsvWriter {

    /**
     * Initialize writer
     *
     * @param config Config
     * @param file   File to be written
     */
    public DefaultCsvWriter(CsvFileConfig config, File file) {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    /**
     * {@inheritDoc}
     *
     * @param line CSV line
     */
    @Override
    public void write(CsvLine line) {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    /**
     * {@inheritDoc}
     *
     * @param lines Multiple CSV lines
     */
    @Override
    public void write(Collection<CsvLine> lines) {
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
}
