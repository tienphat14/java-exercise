package languagebasic;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of intervals (an interval is defined by start and end property), implement a method to return all overlapping interval pairs.
 *     Example:
 *     Given [11, 15], [3, 9], [1, 4], [15, 18] => return [11, 15] and [15, 18], [3, 9] and [1, 4].
 *     Given [1, 5], [6, 8], [5, 12], [2, 6] => return [1, 5] and [5, 12], [1, 5] and [5, 12], [1, 5] and [2, 6], [6, 8] and [5, 12], [5, 12] and [2, 6]
 */
public class OverlappingIntervalPairs {

    /**
     *
     * @param intervalList An collection of intervals
     * @return All overlapping interval pairs
     *
     */
    public Set<IntervalPair> findOverlappingIntervalPairs(List<Interval> intervalList) {
        if (intervalList == null) {
            return Collections.emptySet();
        }

        Set<IntervalPair> result = new HashSet<>();

        for (int i = 0; i < intervalList.size() - 1; i++) {
            for (int j = i + 1; j < intervalList.size(); j++) {
                Interval left = intervalList.get(i);
                Interval right = intervalList.get(j);
                if (left.getStart() <= right.getEnd() && left.getEnd() >= right.getStart()) {
                    result.add(new IntervalPair(left, right));
                }
            }
        }

        return result;
    }
}
