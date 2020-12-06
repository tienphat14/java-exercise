package coaching.csv;

import java.util.List;

/**
 * Supplies information about CSV line
 */
public class CsvLine {

    private int position;
    private String data;
    private List<String> listData;
    /**
     * Get data at specific position in a row
     *
     * @param index Position of segment
     * @return Data
     */
    public String get(int index) throws  IndexOutOfBoundsException{
        return listData.get(index);
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
