package coaching.csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

/**
 * TODO Implement CSV writing logic here
 */
public class DefaultCsvWriter implements CsvWriter {
    private File file;
    private CsvFileConfig csvFileConfig;
    private FileWriter fileWriter;
    /**
     * Initialize writer
     *
     * @param config Config
     * @param file   File to be written
     */
    public DefaultCsvWriter(CsvFileConfig config, File file) throws IOException {
        if (config == null || file == null) {
            throw new IOException();
        }
        this.file = file;
        this.csvFileConfig = config;
    }

    /**
     * {@inheritDoc}
     *
     * @param line CSV line
     */
    @Override
    public void write(CsvLine line) throws IOException {
        fileWriter = new FileWriter(file);
        fileWriter.append(convertCsvLineToString(line,this.csvFileConfig));
        fileWriter.flush();
        fileWriter.close();
    }

    /**
     * {@inheritDoc}
     *
     * @param lines Multiple CSV lines
     */
    @Override
    public void write(Collection<CsvLine> lines) throws IOException {
        fileWriter = new FileWriter(file);
        for (CsvLine line : lines) {
            fileWriter.append(convertCsvLineToString(line,this.csvFileConfig));
        }
        fileWriter.flush();
        fileWriter.close();
    }

    /**
     * {@inheritDoc}
     *
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        if (fileWriter != null) {
            fileWriter.close();
        }
    }

    public String convertCsvLineToString(CsvLine line, CsvFileConfig config) {
        StringBuilder row = new StringBuilder();
        int size = line.getSegmentsInLine().size();
        for (int i = 0; i < size; i++) {
            row.append(line.getSegmentsInLine().get(i));
            if (i < size - 1) {
                row.append(config.getDelimiter());
            } else {
                row.append("\n");
            }
        }
        return row.toString();
    }


}
