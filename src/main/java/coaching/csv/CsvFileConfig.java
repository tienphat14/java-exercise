package coaching.csv;

/**
 * Configuration used to determine parsing strategy and writing strategy
 */
public class CsvFileConfig {
    private String delimiter;
    private boolean quoted;

    public static CsvFileConfig DEFAULT = new CsvFileConfig(",", true);

    public CsvFileConfig() {
    }

    public CsvFileConfig(String delimiter, boolean quoted) {
        this.delimiter = delimiter;
        this.quoted = quoted;
    }

    /**
     * Character as splitting character between segments
     *
     * @param delimiter Delimiter character
     */
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    /**
     * Is data wrapped with double quotes
     *
     * @param quoted true is double-quotes-wrapped data, otherwise false
     */
    public void setQuoteMode(boolean quoted) {
        this.quoted = quoted;
    }

    @Override
    public String toString() {
        return "CsvFileConfig{" +
                "delimiter='" + delimiter + '\'' +
                ", quoted=" + quoted +
                '}';
    }
}
