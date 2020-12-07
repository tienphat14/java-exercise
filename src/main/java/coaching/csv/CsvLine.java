package coaching.csv;

/**
 * Supplies information about CSV line
 */
public class CsvLine {
    private int position;
    private String data;

    /**
     * Get data at specific position in a row
     *
     * @param index Position of segment
     * @return Data
     */
    public String get(int index) {
        throw new UnsupportedOperationException("This method is not implemented yet, please implement");
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
