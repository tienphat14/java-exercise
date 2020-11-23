package coaching.csv;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.fail;

public class CsvTestUtils {

    public static CsvFileConfig createCsvFileConfig() {
        final CsvFileConfig config = new CsvFileConfig();
        config.setDelimiter(",");
        config.setQuoteMode(true);
        return config;
    }

    public static List<CsvLine> createDumpCsvLines() {
        final CsvLine header = new CsvLine();
        final CsvLine data = new CsvLine();

        header.set(0, "FirstName");
        header.set(1, "LastName");

        data.set(0, "John");
        data.set(1, "Biden");
        return Arrays.asList(header, data);
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
