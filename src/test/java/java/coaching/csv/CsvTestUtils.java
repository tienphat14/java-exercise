package java.coaching.csv;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import static org.junit.Assert.fail;

public class CsvTestUtils {

    public static CsvFileConfig createCsvFileConfig() {
        final CsvFileConfig config = new CsvFileConfig();
        config.setDelimiter(",");
        config.setQuoteMode(true);
        return config;
    }

    public static File createTestFile() throws IOException {
        final File file = new File("target/" + UUID.randomUUID().toString() + ".csv");
        file.getParentFile().mkdirs();
        file.createNewFile();
        return file;
    }

    public static void writeWithAssertion(CsvWriter writer, CsvLine csvLine) {
        try {
            writer.write(csvLine);
        } catch (IOException e) {
            fail();
        }
    }

    public static void writeWithAssertion(CsvWriter writer, Collection<CsvLine> csvLines) {
        try {
            writer.write(csvLines);
        } catch (IOException e) {
            fail();
        }
    }
}
