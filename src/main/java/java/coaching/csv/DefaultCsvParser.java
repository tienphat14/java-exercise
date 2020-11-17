package java.coaching.csv;

import java.io.File;
import java.util.Iterator;

/**
 * Reading a file from file system and then parse it to list of CSV lines
 */
public class DefaultCsvParser implements CsvParser {

    /**
     * Initialize parser
     *
     * @param parserConfig Configuration
     */
    public DefaultCsvParser(CsvFileConfig parserConfig) {
    }

    /**
     * Parse file to CSV lines
     *
     * @param file Input file
     * @return Collection of CSV lines
     */
    @Override
    public Iterator<CsvLine> parse(File file) {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }
}
