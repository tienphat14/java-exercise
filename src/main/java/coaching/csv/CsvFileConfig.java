package coaching.csv;

import java.io.File;

/**
 * Configuration used to determine parsing strategy and writing strategy
 */
public class CsvFileConfig {
    private String quoteCharacter = "\"";
    private String delimiter;
    private String newlineString = "\n";
    private File csvFile = null;
    private boolean quoted;


    /**
     * Character as splitting character between segments
     *
     * @param delimiter Delimiter character
     */
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    /**
     * Is data wrapped with double quotes
     *
     * @param quoted true is double-quotes-wrapped data, otherwise false
     */
    public void setQuoteMode(boolean quoted) {
        this.quoted = quoted;
    }

    public boolean getQuoteMode(boolean quoted){
        return quoted;
    }

    public File getCsvFile() {
        return csvFile;
    }

    public void setCsvFile(File csvFile) {
        this.csvFile = csvFile;
    }

    public String getQuoteCharacter() {
        return quoteCharacter;
    }

    public void setQuoteCharacter(String quoteCharacter) {
        this.quoteCharacter = quoteCharacter;
    }
}
