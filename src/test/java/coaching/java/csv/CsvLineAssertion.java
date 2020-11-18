package coaching.java.csv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public final class CsvLineAssertion {
    private final List<Line> expectedLines = new ArrayList<>();

    public static CsvLineAssertion create() {
        return new CsvLineAssertion();
    }

    public Line expectLine(int number) {
        final Line expectedLine = new Line(number);
        expectedLines.add(expectedLine);
        return expectedLine;
    }

    public void assertCsvLine(CsvParser parser) {
        final Set<Line> trackedLines = new HashSet<>(this.expectedLines);
        final Map<Integer, Line> expectedLines = this.expectedLines.stream()
                .collect(Collectors.toMap(Line::getLineNumber, line -> line));
        int count = 0;

        while (parser.hasNext()) {
            if (expectedLines.containsKey(count)) {
                final CsvLine line = parser.next();
                final Line expectedLine = expectedLines.get(count);

                expectedLine.assertCsvLine(line);
                trackedLines.remove(expectedLine);
            }
            count++;
        }

        assertEquals("These lines " + trackedLines + " does not match any actual lines", 0, trackedLines.size());
    }

    public class Line {
        private final Integer lineNumber;
        private final Map<Integer, String> expectedSegments = new HashMap<>();

        public Line(int lineNumber) {
            this.lineNumber = lineNumber;
        }

        public Line atSegment(int position, String expected) {
            expectedSegments.put(position, expected);
            return this;
        }

        public CsvLineAssertion and() {
            return CsvLineAssertion.this;
        }

        public Integer getLineNumber() {
            return lineNumber;
        }

        public void assertCsvLine(CsvLine line) {
            for (Map.Entry<Integer, String> entry : expectedSegments.entrySet()) {
                assertEquals("Expected segment does not match actual at line " + lineNumber,
                        entry.getValue(), line.get(entry.getKey()));
            }
        }
    }

}
