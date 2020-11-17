package java.coaching.csv;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;

import static java.coaching.csv.CsvTestUtils.createCsvFileConfig;
import static java.coaching.csv.CsvTestUtils.createTestFile;
import static java.coaching.csv.CsvTestUtils.writeWithAssertion;
import static org.junit.Assert.assertEquals;

/**
 * Required Knowledge
 * - Java basic (conditional statement, loop, ...)
 * - Java IO
 * - Java Collection
 * <p>
 * Requirements
 * - Make sure your code stay consistent
 * - Easily to maintain and highly extensible is a plus
 * - Well documented code
 */
public class DefaultCsvWriterTest {

    @Test
    public void whenWriteSingle_QuoteModeOn_ThenWrite() throws IOException {
        List<String> actualLines = execute((csvFileConfig, testFile) -> {
            final CsvWriter writer = new DefaultCsvWriter(csvFileConfig, testFile);
            final CsvLine line = new CsvLine();

            line.set(0, "FirstName");
            line.set(1, "LastName");
            writeWithAssertion(writer, line);
        });

        assertEquals(1, actualLines.size());
        assertEquals("\"FirstName\",\"LastName\"", actualLines.get(0));
    }

    @Test
    public void whenWriteSingle_QuoteModeOff_ThenWrite() throws IOException {
        List<String> actualLines = execute((csvFileConfig, testFile) -> {
            csvFileConfig.setQuoteMode(false);
            final CsvWriter writer = new DefaultCsvWriter(csvFileConfig, testFile);
            final CsvLine line = new CsvLine();

            line.set(0, "FirstName");
            line.set(1, "LastName");
            writeWithAssertion(writer, line);
        });

        assertEquals(1, actualLines.size());
        assertEquals("FirstName,LastName", actualLines.get(0));
    }

    @Test
    public void whenWriteSingle_PipeLineDelimiter_ThenWrite() throws IOException {
        List<String> actualLines = execute((csvFileConfig, testFile) -> {
            csvFileConfig.setDelimiter("|");
            final CsvWriter writer = new DefaultCsvWriter(csvFileConfig, testFile);
            final CsvLine line = new CsvLine();

            line.set(0, "FirstName");
            line.set(1, "LastName");
            writeWithAssertion(writer, line);
        });

        assertEquals(1, actualLines.size());
        assertEquals("\"FirstName\"|\"LastName\"", actualLines.get(0));
    }

    @Test
    public void whenWriteMultiple_QuoteModeOn_ThenWrite() throws IOException {
        List<String> actualLines = execute((csvFileConfig, testFile) -> {
            final CsvWriter writer = new DefaultCsvWriter(csvFileConfig, testFile);
            final CsvLine header = new CsvLine();
            final CsvLine data = new CsvLine();

            header.set(0, "FirstName");
            header.set(1, "LastName");

            data.set(0, "John");
            data.set(1, "Biden");
            writeWithAssertion(writer, Arrays.asList(header, data));
        });

        assertEquals(2, actualLines.size());
        assertEquals("\"FirstName\",\"LastName\"", actualLines.get(0));
        assertEquals("\"John\",\"Biden\"", actualLines.get(1));
    }

    @Test
    public void whenWriteMultiple_QuoteModeOff_ThenWrite() throws IOException {
        List<String> actualLines = execute((csvFileConfig, testFile) -> {
            csvFileConfig.setQuoteMode(false);
            final CsvWriter writer = new DefaultCsvWriter(csvFileConfig, testFile);
            final CsvLine header = new CsvLine();
            final CsvLine data = new CsvLine();

            header.set(0, "FirstName");
            header.set(1, "LastName");

            data.set(0, "John");
            data.set(1, "Biden");
            writeWithAssertion(writer, Arrays.asList(header, data));
        });

        assertEquals(2, actualLines.size());
        assertEquals("FirstName,LastName", actualLines.get(0));
        assertEquals("John,Biden", actualLines.get(1));
    }

    @Test
    public void whenWriteMultiple_PipelineDelimiter_ThenWrite() throws IOException {
        List<String> actualLines = execute((csvFileConfig, testFile) -> {
            csvFileConfig.setQuoteMode(false);
            final CsvWriter writer = new DefaultCsvWriter(csvFileConfig, testFile);
            final CsvLine header = new CsvLine();
            final CsvLine data = new CsvLine();

            header.set(0, "FirstName");
            header.set(1, "LastName");

            data.set(0, "John");
            data.set(1, "Biden");
            writeWithAssertion(writer, Arrays.asList(header, data));
        });

        assertEquals(2, actualLines.size());
        assertEquals("\"FirstName\"|\"LastName\"", actualLines.get(0));
        assertEquals("\"John\"|\"Biden\"", actualLines.get(1));
    }

    @Test(expected = IOException.class)
    public void whenWriteSingle_NonExistingFile_ThenReject() throws IOException {
        final CsvWriter writer = new DefaultCsvWriter(createCsvFileConfig(), new File("non-existing.csv"));
        writer.write(new CsvLine());
    }

    @Test(expected = IOException.class)
    public void whenWriteMultiple_NonExistingFile_ThenReject() throws IOException {
        final CsvWriter writer = new DefaultCsvWriter(createCsvFileConfig(), new File("non-existing.csv"));
        writer.write(Arrays.asList(new CsvLine(), new CsvLine()));
    }

    private List<String> execute(BiConsumer<CsvFileConfig, File> execute) throws IOException {
        final List<String> actualLines = new ArrayList<>();
        final File testFile = createTestFile();
        final CsvFileConfig csvFileConfig = createCsvFileConfig();

        execute.accept(csvFileConfig, testFile);
        try (Scanner scanner = new Scanner(testFile)) {
            while (scanner.hasNext()) {
                actualLines.add(scanner.next());
            }
            return actualLines;
        }
    }
}
