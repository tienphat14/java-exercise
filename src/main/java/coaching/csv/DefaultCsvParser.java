package coaching.csv;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO Implement CSV parsing logic here
 */
public class DefaultCsvParser implements CsvParser {
    private File file;
    private CsvFileConfig parserConfig;
    private CsvIterator csvIterator;
    /**
     * Initialize parser
     *
     * @param file         CSV file
     * @param parserConfig Configuration
     */
    public DefaultCsvParser(File file, CsvFileConfig parserConfig) throws IllegalArgumentException {
        if (file == null || parserConfig == null) {
            throw new IllegalArgumentException();
        }
        this.file = file;
        this.parserConfig = parserConfig;
        this.csvIterator = new CsvIterator(file);
    }

    /**
     * Close the csv iterator
     *
     * @throws IOException
     */
    @Override
    public void close() {
        this.csvIterator.close();
        }

    /**
     * Check the existence of a next line
     * @return true if having a next line
     */
    @Override
    public boolean hasNext() {
        return csvIterator.hasNext();
    }

    /**
     * Get the next line
     *
     * @return a csv line
     */
    @Override
    public CsvLine next() {
        String line = csvIterator.next();
        if (parserConfig.getDelimiter() == "|") {
            return mapToCsvLine(Stream.of(line.split("\\|"))
                    .map(String::trim)
                    .collect(Collectors.toList()));
        }
        return mapToCsvLine(Stream.of(line.split(parserConfig.getDelimiter()))
                .map(String::trim)
                .collect(Collectors.toList()));
    }

    /**
     * Convert a list of string to a map of csv line
     * @param reader
     * @return a map of csv line
     */
    private CsvLine mapToCsvLine(List<String> reader) {

        CsvLine csvLine = new CsvLine();
        for (int i = 0; i < reader.size(); i++) {
            csvLine.set(i, reader.get(i));
        }
        return csvLine;
    }
}
