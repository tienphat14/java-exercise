package coaching.java.csv;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static coaching.java.csv.CsvTestUtils.createCsvFileConfig;

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

    @Test(expected = IOException.class)
    public void whenParse_NonExistingFile_ThenReject() throws URISyntaxException, IOException {
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

    private void execute(CsvFileConfig config, String fileName) throws URISyntaxException, IOException {
        // Get test data from resources
        final File file = Paths.get(DefaultCsvParserTest.class.getResource(fileName).toURI()).toFile();
        final CsvParser parser = new DefaultCsvParser(file, config);

        // Assert lines
        CsvLineAssertion
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

        // Close resources
        parser.close();
    }
}
