package coaching.csv;

import coaching.exception.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * TODO Implement CSV parsing logic here
 */
public class DefaultCsvParser implements CsvParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultCsvParser.class);
    private Scanner scanner;
    private final CsvFileConfig parserConfig;

    /**
     * Initialize parser
     *
     * @param file         CSV file
     * @param parserConfig Configuration
     */
    public DefaultCsvParser(File file, CsvFileConfig parserConfig) {
        if (file == null) {
            throw new IllegalArgumentException("File is null");
        }
        this.parserConfig = parserConfig;
        try {
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            if (this.scanner != null) {
                this.scanner.close();
            }
            String errMsg = "Can not read file";
            LOGGER.error(errMsg, e);
            throw new ParserException(errMsg, e);
        } catch (NullPointerException e) {
            String errMsg = "Illegal arguments";
            LOGGER.error(errMsg, e);
            throw new IllegalArgumentException(errMsg, e);
        }
    }

    private List<String> readFromCsv(String line) {
        return new Scanner(line).useDelimiter(Pattern.compile(this.parserConfig.getDelimiter())).tokens().collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     *
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        if (this.scanner == null) {
            throw new IOException("File is already closed");
        }
        this.scanner.close();
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        if (this.scanner != null) {
            return this.scanner.hasNextLine();
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public CsvLine next() {
        if (this.scanner == null) {
            throw new ParserException("Can not read the file", new NullPointerException());
        }
        List<String> attributes = readFromCsv(this.scanner.nextLine());
        CsvLine csvLine = new CsvLine();
        for (int idx = 0; idx < attributes.size(); idx++) {
            String value = attributes.get(idx);
            if (this.parserConfig.isQuoted()) {
                csvLine.set(idx, value.substring(1, value.length() - 1));
                continue;
            }
            csvLine.set(idx, value);
        }
        return csvLine;
    }
}
