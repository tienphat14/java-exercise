package coaching.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Supplies information about CSV line
 */
public class CsvLine {

    Map<Integer, String> segments = new HashMap<>();

    /**
     * Get data at specific position in a row
     *
     * @param index Position of segment
     * @return Data
     */
    public String get(int index) {
        return segments.get(index);
    }

    /**
     * Set data in a specific position
     *
     * @param position Position
     * @param data     Data
     */
    public void set(int position, String data) {
        segments.put(position, data);
    }

    public Map<Integer, String> getSegmentsInLine() {
        return segments;
    }
}
