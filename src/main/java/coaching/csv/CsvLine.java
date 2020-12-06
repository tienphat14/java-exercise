package coaching.csv;

import java.io.Serializable;
import java.util.*;

/**
 * Supplies information about CSV line
 */
public class CsvLine implements Serializable, Iterable<String>{

    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final long serialVersionUID = 1L;
    private long characterPosition;
    private String comment;
    private Map<String, Integer> mapping;
    private long recordNumber;
    private String[] values;

    CsvLine(){}
    
    CsvLine(String[] values, Map<String, Integer> mapping, String comment, long recordNumber, long characterPosition) {
        this.recordNumber = recordNumber;
        this.values = values != null ? values : EMPTY_STRING_ARRAY;
        this.mapping = mapping;
        this.comment = comment;
        this.characterPosition = characterPosition;
    }

    public String get(Enum<?> e) {
        return this.get(e.toString());
    }

    public String get(int i) {
        return this.values[i];
    }

    public String get(String name) {
        if (this.mapping == null) {
            throw new IllegalStateException("No header mapping was specified, the record values can't be accessed by name");
        } else {
            Integer index = (Integer)this.mapping.get(name);
            if (index == null) {
                throw new IllegalArgumentException(String.format("Mapping for %s not found, expected one of %s", name, this.mapping.keySet()));
            } else {
                try {
                    return this.values[index];
                } catch (ArrayIndexOutOfBoundsException var4) {
                    throw new IllegalArgumentException(String.format("Index for header '%s' is %d but CSVRecord only has %d values!", name, index, this.values.length));
                }
            }
        }
    }

    public long getCharacterPosition() {
        return this.characterPosition;
    }

    public String getComment() {
        return this.comment;
    }

    public long getRecordNumber() {
        return this.recordNumber;
    }

    public boolean isConsistent() {
        return this.mapping == null || this.mapping.size() == this.values.length;
    }

    public boolean hasComment() {
        return this.comment != null;
    }

    public boolean isMapped(String name) {
        return this.mapping != null && this.mapping.containsKey(name);
    }

    public boolean isSet(String name) {
        return this.isMapped(name) && (Integer)this.mapping.get(name) < this.values.length;
    }

    public Iterator<String> iterator() {
        return this.toList().iterator();
    }

    <M extends Map<String, String>> M putIn(M map) {
        if (this.mapping == null) {
            return map;
        } else {
            Iterator var2 = this.mapping.entrySet().iterator();

            while(var2.hasNext()) {
                Map.Entry<String, Integer> entry = (Map.Entry)var2.next();
                int col = (Integer)entry.getValue();
                if (col < this.values.length) {
                    map.put(entry.getKey(), this.values[col]);
                }
            }

            return map;
        }
    }

    public int size() {
        return this.values.length;
    }

    private List<String> toList() {
        return Arrays.asList(this.values);
    }

    public Map<String, String> toMap() {
        return this.putIn(new HashMap(this.values.length));
    }

    public String toString() {
        return "CSVRecord [comment=" + this.comment + ", mapping=" + this.mapping + ", recordNumber=" + this.recordNumber + ", values=" + Arrays.toString(this.values) + "]";
    }

    String[] values() {
        return this.values;
    }

    public void set(int i, String firstName) {
    }
}
