package coaching.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public final class CsvLinesAssertion {
    private final List<CsvSegmentAssertion> expectedCsvSegmentAssertions = new ArrayList<>();

    public static CsvLinesAssertion create() {
        return new CsvLinesAssertion();
    }

    public CsvSegmentAssertion expectLine(int number) {
        final CsvSegmentAssertion expectedCsvSegmentAssertion = new CsvSegmentAssertion(number);
        expectedCsvSegmentAssertions.add(expectedCsvSegmentAssertion);
        return expectedCsvSegmentAssertion;
    }

    public void assertCsvLine(CsvParser parser) throws IOException {
        final Set<CsvSegmentAssertion> trackedCsvSegmentAssertions = new HashSet<>(this.expectedCsvSegmentAssertions);
        final Map<Integer, CsvSegmentAssertion> expectedLines = this.expectedCsvSegmentAssertions.stream()
                .collect(Collectors.toMap(CsvSegmentAssertion::getLineNumber, csvSegmentAssertion -> csvSegmentAssertion));
        int count = 0;

        while (parser.hasNext()) {
            if (expectedLines.containsKey(count)) {
                final CsvLine line = parser.next();
                final CsvSegmentAssertion expectedCsvSegmentAssertion = expectedLines.get(count);

                expectedCsvSegmentAssertion.assertCsvLine(line);
                trackedCsvSegmentAssertions.remove(expectedCsvSegmentAssertion);
            }
            count++;
        }

        assertEquals("These lines " + trackedCsvSegmentAssertions + " does not match any actual lines", 0, trackedCsvSegmentAssertions.size());
    }

    public class CsvSegmentAssertion {
        private final Integer lineNumber;
        private final Map<Integer, String> expectedSegments = new HashMap<>();

        public CsvSegmentAssertion(int lineNumber) {
            this.lineNumber = lineNumber;
        }

        public CsvSegmentAssertion atSegment(int position, String expected) {
            expectedSegments.put(position, expected);
            return this;
        }

        public CsvLinesAssertion and() {
            return CsvLinesAssertion.this;
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
