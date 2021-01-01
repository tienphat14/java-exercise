package coaching.csv;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Supplies information about CSV line
 */
public class CsvLine {

    private final Map<Integer, String> data = new HashMap<>();

    /**
     * Get data at specific position in a row
     *
     * @param index Position of segment
     * @return Data
     */
    public String get(int index) {
        return Optional.of(this.data.get(index)).orElse("NaN");
    }

    /**
     * Set data in a specific position
     *
     * @param position Position
     * @param data     Data
     */
    public void set(int position, String data) {
        if (data == null || data.equals("")) {
            throw new IllegalArgumentException("Value can not be empty or blank", new NullPointerException());
        }
        this.data.put(position, data);
    }
}
