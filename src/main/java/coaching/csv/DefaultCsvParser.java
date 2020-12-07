package coaching.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO Implement CSV parsing logic here
 */
public class DefaultCsvParser implements CsvParser {

    private final Scanner scanner;
    private Map<String, String> headers = new HashMap<>();

    /**
     * Initialize parser
     *
     * @param file         CSV file
     * @param parserConfig Configuration
     */
    public DefaultCsvParser(File file, CsvFileConfig parserConfig) {
        try {
            this.scanner = new Scanner(file);
            setHeaders();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    private void setHeaders() {

    }

    /**
     * {@inheritDoc}
     *
     * @throws IOException
     */
    @Override
    public void close() {
        if (this.scanner != null) {
            this.scanner.close();
        }
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
        if (this.scanner != null) {
            String line = this.scanner.nextLine();
            List<String> attributes = this.scanner.useDelimiter(",").tokens().collect(Collectors.toList());

        }
        throw new UnsupportedOperationException("This method is not implemented yet");
    }
}
