package java.coaching.csv;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * Required Knowledge
 * - Java basic (conditional statement, loop, ...)
 * - Java IO
 * - Java Collection
 *
 * Requirements
 * - Make sure your code stay consistent
 * - Easily to maintain and highly extensible is a plus
 * - Well documented code
 */
public class CsvParserTest {

    @Test
    public void whenParse_QuotedCsv_ThenCorrectlyParse() throws URISyntaxException {
        final CsvFileConfig parserConfig = new CsvFileConfig();
        parserConfig.setDelimiter("|");
        parserConfig.setQuoteMode(true);
        executeTest(parserConfig, "/quoted.csv");
    }

    @Test
    public void whenParse_UnquotedCsv_ThenCorrectlyParse() throws URISyntaxException {
        final CsvFileConfig parserConfig = new CsvFileConfig();
        parserConfig.setDelimiter("|");
        parserConfig.setQuoteMode(false);
        executeTest(parserConfig, "/unquoted.csv");
    }

    @Test
    public void whenParse_CommaDelimiter_ThenCorrectlyParse() throws URISyntaxException {
        final CsvFileConfig parserConfig = new CsvFileConfig();
        parserConfig.setDelimiter(",");
        parserConfig.setQuoteMode(true);
        executeTest(parserConfig, "/comma.csv");
    }

    /**
     * The CSV to be considered as an abnormal file contains incorrect number
     * of segments not matching number of header columns, please refer to abnormal.csv
     * file for details
     */
    @Test(expected = ParseException.class)
    public void whenParse_AbnormalDelimiter_ThenReject() throws URISyntaxException {
        final CsvFileConfig parserConfig = new CsvFileConfig();
        parserConfig.setDelimiter(",");
        parserConfig.setQuoteMode(true);
        executeTest(parserConfig, "/abnormal.csv");
    }

    private void executeTest(CsvFileConfig config, String fileName) throws URISyntaxException {
        // Get test data from resources
        final File file = Paths.get(CsvParserTest.class.getResource(fileName).toURI()).toFile();


        final CsvParser parser = new DefaultCsvParser(config);
        final Iterator<CsvLine> csvLines = parser.parse(file);

        // Iterate through CSV lines for result
        int count = 0;
        while (csvLines.hasNext()) {
            final CsvLine csvLine = csvLines.next();

            // Header line assertion
            if (count == 0) {
                Assert.assertEquals("FirstName", csvLine.get(0));
                Assert.assertEquals("LastName", csvLine.get(1));

                // Data line assertion
            } else if (count == 1) {
                Assert.assertEquals("John", csvLine.get(0));
                Assert.assertEquals("Biden", csvLine.get(1));
            } else if (count == 2) {
                Assert.assertEquals("Donald", csvLine.get(0));
                Assert.assertEquals("Trump", csvLine.get(1));
            }

            count++;
        }
    }
}
