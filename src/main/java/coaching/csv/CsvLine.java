package coaching.csv;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Supplies information about CSV line
 */
public class CsvLine {

    private Map<Integer, String> dataMap;

    public CsvLine() {
        dataMap = new HashMap<>();
    }

    /**
     * Get data at specific position in a row
     *
     * @param index Position of segment
     * @return Data
     */
    public String get(int index) {
        return dataMap.get(index);
    }

    /**
     * Set data in a specific position
     *
     * @param position Position
     * @param data     Data
     */
    public void set(int position, String data) {
        dataMap.put(position, data);
    }

    public Collection<String> getData() {
        return dataMap.values();
    }
}
