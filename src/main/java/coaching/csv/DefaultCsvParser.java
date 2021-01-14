package coaching.csv;

import java.io.File;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * TODO Implement CSV parsing logic here
 */
public class DefaultCsvParser implements CsvParser {
    private File file;
    private LineNumberReader reader;
    private CsvFileConfig csvDesc;
    private StringBuilder sb = null;
    private boolean nextRead;
    private String[] currentLine;
    private String[] nextLine;
    private long lineNo;



    /**
     * Initialize parser
     *
     * @param file         CSV file
     * @param parserConfig Configuration
     */
    public DefaultCsvParser(File file, CsvFileConfig parserConfig) {
        this.file =  file;
        this.csvDesc = parserConfig;
        this.sb = new StringBuilder();
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        return this.nextLine != null;
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

    @Override
    public void close() throws IOException {

    }
}
