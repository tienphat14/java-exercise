package coaching.csv;

/**
 * Supplies information about CSV line
 */
public class CsvLine {

    private String[] data;

    /**
     * Get data at specific position in a row
     *
     * @param index Position of segment
     * @return Data
     */
    public String get(int index) {
        return this.data[index];
        //throw new UnsupportedOperationException("This method is not implemented yet, please implement");
    }

    /**
     * Set data in a specific position
     *
     * @param position Position
     * @param data     Data
     */
    public void set(int position, String data) {
        throw new UnsupportedOperationException("This method is not implemented yet, please implement");
    }
}
