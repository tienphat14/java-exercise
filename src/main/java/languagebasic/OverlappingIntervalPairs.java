package languagebasic;

import java.util.ArrayList;
import java.util.List;

public class OverlappingIntervalPairs {
    /*
    Given a collection of intervals (an interval is defined by start and end property), implement a method to return all overlapping interval pairs.
    Example:
    Given [11, 15], [3, 9], [1, 4], [15, 18] => return [11, 15] and [15, 18], [3, 9] and [1, 4].
    Given [1, 5], [6, 8], [5, 12], [2, 6] => return [1, 5] and [5, 12], [1, 5] and [2, 6], [6, 8] and [5, 12], [5, 12] and [2, 6]
     */

    public List<List<List<Integer>>> naiveMethod(ArrayList<ArrayList<Integer>> intervals) {
        List<List<List<Integer>>> result = new ArrayList<>();
        for (int prevIdx = 0; prevIdx < intervals.size() - 1; prevIdx++) {
            List<Integer> previous = intervals.get(prevIdx);
            Integer prevFirstEle = previous.get(0);
            Integer prevSecondEle = previous.get(1);
            for (int currIdx = prevIdx + 1; currIdx < intervals.size(); currIdx++) {
                List<Integer> current = intervals.get(currIdx);
                Integer currFirstEle = current.get(0);
                Integer currSecondEle = current.get(1);
                if ((prevFirstEle <= currFirstEle && currFirstEle <= prevSecondEle)
                        || (currFirstEle <= prevFirstEle && prevFirstEle <= currSecondEle)
                ) {
                    List<List<Integer>> tmp = new ArrayList<>();
                    tmp.add(previous);
                    tmp.add(current);
                    result.add(tmp);
                }
            }
        }
        return result;
    }
}
