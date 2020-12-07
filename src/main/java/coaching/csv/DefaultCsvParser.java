package coaching.csv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * TODO Implement CSV parsing logic here
 */
public class DefaultCsvParser implements CsvParser {
    private File file;
    private CsvFileConfig parserConfig;
    private FileInputStream in;

    /**
     * Initialize parser
     *
     * @param file         CSV file
     * @param parserConfig Configuration
     */
    public DefaultCsvParser(File file, CsvFileConfig parserConfig) {
        this.file = file;
        this.parserConfig = parserConfig;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        if (this.in != null) {
            this.in.close();
        }
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

    @Override
    public CsvParser parse() {
        try {
            in = new FileInputStream(file);
        }catch (FileNotFoundException e){
            new Exception(String.format("Can not find file : %s",file.getAbsoluteFile()));
        }
        return this;
    }
}
