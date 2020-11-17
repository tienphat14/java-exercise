package java.coaching.csv;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.coaching.csv.CsvTestUtils.createCsvFileConfig;
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
public class CsvParserTest {

    @Test
    public void whenParse_QuotedCsv_ThenCorrectlyParse() throws URISyntaxException {
        final CsvFileConfig parserConfig = createCsvFileConfig();
        parserConfig.setDelimiter("|");
        assertCsvLines(execute(parserConfig, "/quoted.csv"));
    }

    @Test
    public void whenParse_UnquotedCsv_ThenCorrectlyParse() throws URISyntaxException {
        final CsvFileConfig parserConfig = createCsvFileConfig();
        parserConfig.setDelimiter("|");
        parserConfig.setQuoteMode(false);
        assertCsvLines(execute(parserConfig, "/unquoted.csv"));
    }

    @Test
    public void whenParse_CommaDelimiter_ThenCorrectlyParse() throws URISyntaxException {
        final CsvFileConfig parserConfig = createCsvFileConfig();
        parserConfig.setDelimiter(",");
        assertCsvLines(execute(parserConfig, "/comma.csv"));
    }

    @Test(expected = IOException.class)
    public void whenParse_NonExistingFile_ThenReject() throws URISyntaxException {
        execute(createCsvFileConfig(), "/not-found.csv");
    }

    /**
     * The CSV to be considered as an abnormal file contains incorrect number
     * of segments not matching number of header columns, please refer to abnormal.csv
     * file for details
     */
    @Test(expected = IOException.class)
    public void whenParse_AbnormalDelimiter_ThenReject() throws URISyntaxException, IOException {
        final CsvFileConfig parserConfig = new CsvFileConfig();
        parserConfig.setDelimiter(",");
        parserConfig.setQuoteMode(true);
        execute(parserConfig, "/abnormal.csv");
    }

    private List<CsvLine> execute(CsvFileConfig config, String fileName) throws URISyntaxException {
        // Get test data from resources
        final File file = Paths.get(CsvParserTest.class.getResource(fileName).toURI()).toFile();
        final List<CsvLine> actualLines = new ArrayList<>();
        final CsvParser parser = new DefaultCsvParser(file, config);

        // Iterate through CSV lines for result
        while (parser.hasNext()) {
            actualLines.add(parser.next());
        }

        return actualLines;
    }

    private void assertCsvLines(List<CsvLine> lines) {
        assertEquals(3, lines.size());

        CsvLine header = lines.get(0);
        assertEquals("FirstName", header.get(0));
        assertEquals("LastName", header.get(1));

        CsvLine data1 = lines.get(1);
        assertEquals("John", data1.get(0));
        assertEquals("Biden", data1.get(1));

        CsvLine data2 = lines.get(1);
        assertEquals("Donald", data2.get(0));
        assertEquals("Trump", data2.get(1));
    }
}
