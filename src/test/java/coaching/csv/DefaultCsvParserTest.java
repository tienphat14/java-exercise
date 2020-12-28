package coaching.csv;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static coaching.csv.CsvTestUtils.createCsvFileConfig;

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
public class DefaultCsvParserTest {

    @Test
    public void whenParse_QuotedCsv_ThenCorrectlyParse() throws URISyntaxException, IOException {
        final CsvFileConfig parserConfig = createCsvFileConfig();
        parserConfig.setDelimiter("|");
        execute(parserConfig, "/quoted.csv");
    }

    @Test
    public void whenParse_UnquotedCsv_ThenCorrectlyParse() throws URISyntaxException, IOException {
        final CsvFileConfig parserConfig = createCsvFileConfig();
        parserConfig.setDelimiter("|");
        parserConfig.setQuoteMode(false);
        execute(parserConfig, "/unquoted.csv");
    }

    @Test
    public void whenParse_CommaDelimiter_ThenCorrectlyParse() throws URISyntaxException, IOException {
        final CsvFileConfig parserConfig = createCsvFileConfig();
        parserConfig.setDelimiter(",");
        execute(parserConfig, "/comma.csv");
    }

    @Test(expected = NullPointerException.class)
    public void whenParse_NonExistingFile_ThenReject() throws URISyntaxException, IOException {
        execute(createCsvFileConfig(), "/not-found.csv");
    }

    /**
     * The CSV to be considered as an abnormal file contains incorrect number
     * of segments not matching number of header columns, please refer to abnormal.csv
     * file for details
     */

    @Test(expected = org.junit.ComparisonFailure.class)
    public void whenParse_CorruptedFile_ThenReject() throws URISyntaxException, IOException {
        final CsvFileConfig parserConfig = new CsvFileConfig();
        parserConfig.setDelimiter(",");
        parserConfig.setQuoteMode(true);
        execute(parserConfig, "/abnormal.csv");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenInit_NullConfigParam_ThenReject() throws URISyntaxException {
        final File file = Paths.get(DefaultCsvParserTest.class.getResource("/comma.csv").toURI()).toFile();
        new DefaultCsvParser(file, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenInit_NullFileParam_ThenReject() {
        new DefaultCsvParser(null, createCsvFileConfig());
    }

    private void execute(CsvFileConfig config, String fileName) throws URISyntaxException, IOException {
        // Get test data from resources

        final File file = Paths.get(DefaultCsvParserTest.class.getResource(fileName).toURI()).toFile();
        final CsvParser parser = new DefaultCsvParser(file, config);
        // Assert lines
        if (config.getQuoted()) {
            CsvLinesAssertion
                    .create().expectLine(0)
                    .atSegment(0, "\"FirstName\"")
                    .atSegment(1, "\"LastName\"")
                    .and().expectLine(1)
                    .atSegment(0, "\"John\"")
                    .atSegment(1, "\"Biden\"")
                    .and().expectLine(2)
                    .atSegment(0, "\"Donald\"")
                    .atSegment(1, "\"Trump\"")
                    .and().assertCsvLine(parser);
        } else {
            CsvLinesAssertion
                    .create().expectLine(0)
                    .atSegment(0, "FirstName")
                    .atSegment(1, "LastName")
                    .and().expectLine(1)
                    .atSegment(0, "John")
                    .atSegment(1, "Biden")
                    .and().expectLine(2)
                    .atSegment(0, "Donald")
                    .atSegment(1, "Trump")
                    .and().assertCsvLine(parser);
        }
        // Close resources
        parser.close();
    }
}
