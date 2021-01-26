package coaching.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.regex.Pattern;

public class DefaultCsvParser implements CsvParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultCsvParser.class);
    private final CsvFileConfig config;
    private final int segmentsCount;
    private final BufferedReader reader;

    /**
     * Initialize parser
     *
     * @param file         CSV file
     * @param parserConfig Configuration
     * @throws IllegalArgumentException if null argument
     */
    public DefaultCsvParser(File file, CsvFileConfig parserConfig) throws IOException {
        if (Objects.isNull(file)) {
            throw new IllegalArgumentException("File cannot be null");
        }
        if (Objects.isNull(parserConfig)) {
            throw new IllegalArgumentException("Config cannot be null");
        }
        if (!file.exists()) {
            throw new IOException("File not existed!");
        }
        this.config = parserConfig;
        this.segmentsCount = countSegments(file);
        this.reader = new BufferedReader(new FileReader(file));
    }

    /**
     * {@inheritDoc}
     *
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        reader.close();
    }

    public boolean hasNext() throws IOException {
        return reader.ready();
    }

    public CsvLine next() throws IOException {
        if (hasNext()) {
            String nextLine = reader.readLine();
            return config.isQuoted() ? parseQuotedLine(nextLine) : parseUnquotedLine(nextLine);
        }
        throw new NoSuchElementException("No more line");
    }

    private CsvLine parseQuotedLine(String quotedLine) throws IOException {
        CsvLine csvLine = new CsvLine();
        String[] segments = quotedLine.split(Pattern.quote(config.getDelimiter()));
        if (segments.length != segmentsCount) {
            throw new IOException("Incorrect number of segments");
        }
        for (int i = 0; i < segments.length; i++) {
            csvLine.set(i, segments[i].replaceAll("\"", ""));
        }
        return csvLine;
    }

    private CsvLine parseUnquotedLine(String unquotedLine) throws IOException {
        CsvLine csvLine = new CsvLine();
        String[] segments = unquotedLine.split(Pattern.quote(config.getDelimiter()));
        if (segments.length != segmentsCount) {
            throw new IOException("Incorrect number of segments");
        }
        for (int i = 0; i < segments.length; i++) {
            csvLine.set(i, segments[i]);
        }
        return csvLine;
    }

    private int countSegments(File file) throws IOException {
        try (BufferedReader r = new BufferedReader(new FileReader(file))) {
            if (r.ready()) {
                return r.readLine().split(Pattern.quote(config.getDelimiter())).length;
            }
            return 0;
        }
    }
}
