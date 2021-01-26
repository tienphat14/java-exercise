package coaching.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

public class DefaultCsvWriter implements CsvWriter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultCsvWriter.class);
    private final CsvFileConfig config;
    private final BufferedWriter writer;

    /**
     * Initialize writer
     *
     * @param config Config
     * @param file   File to be written
     */
    public DefaultCsvWriter(CsvFileConfig config, File file) throws IOException {
        if (Objects.isNull(config)) {
            throw new IllegalArgumentException("Config cannot be null");
        }
        if (Objects.isNull(file)) {
            throw new IllegalArgumentException("File cannot be null");
        }
        if (!file.exists()) {
            throw new IOException("File not existed!");
        }
        this.config = config;
        this.writer = new BufferedWriter(new FileWriter(file));
    }

    /**
     * {@inheritDoc}
     *
     * @param line CSV line
     */
    @Override
    public void write(CsvLine line) throws IOException {
        write(Collections.singletonList(line));
    }

    /**
     * {@inheritDoc}
     *
     * @param lines Multiple CSV lines
     */
    @Override
    public void write(Collection<CsvLine> lines) throws IOException {
        for (CsvLine line : lines) {
            String lineToWrite = line
                    .getData()
                    .stream()
                    .map(s -> config.isQuoted() ? "\"" + s + "\"" : s)
                    .collect(Collectors.joining(config.getDelimiter()));
            writer.write(lineToWrite);
            writer.newLine();
        }
        writer.flush();
    }

    /**
     * {@inheritDoc}
     *
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        writer.close();
    }
}
