package java.coaching.csv;

import java.io.File;
import java.util.Iterator;

public interface CsvParser {
    Iterator<CsvLine> parse(File file);
}
