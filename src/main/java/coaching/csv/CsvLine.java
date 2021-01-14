package coaching.csv;

/**
 * Supplies information about CSV line
 */
public class CsvLine {

    private int index;
    private int position;
    private String data;


    /**
     * Get data at specific position in a row
     *
     * @param index Position of segment
     * @return Data
     */
    public String get(int index) {
        return data;
    }

    /**
     * Set data in a specific position
     *
     * @param position Position
     * @param data     Data
     */
    public void set(int position, String data) {
        this.position = position;
        this.data = data;
    }
}
