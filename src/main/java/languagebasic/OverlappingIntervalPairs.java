package languagebasic;

import java.util.ArrayList;
import java.util.List;

/*
Given a collection of intervals (an interval is defined by start and end property), implement a method to return all overlapping interval pairs.
Example:
Given [11, 15], [3, 9], [1, 4], [15, 18] => return [11, 15] and [15, 18], [3, 9] and [1, 4].
Given [1, 5], [6, 8], [5, 12], [2, 6] => return [1, 5] and [5, 12], [1, 5] and [2, 6], [6, 8] and [5, 12], [5, 12] and [2, 6], [6,8] and [2,6]
 */
public class OverlappingIntervalPairs {
    List<List<IntervalPair>> listOverlappingIntervalPairs = new ArrayList<>();
    public static class IntervalPair {
        private int start;
        private int end;

        public IntervalPair() {}

        public IntervalPair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

    public List<List<IntervalPair>> getOverlappingIntervalPairs(List<IntervalPair> list) throws CustomException {
        if (list == null || list.size() <= 1 || list.isEmpty()) {
            throw new CustomException("The list is empty or has only one pair!");
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (isOverlapping(list.get(i), list.get(j))) {
                    List<IntervalPair> anOverlappingIntervalPairs = new ArrayList<>();
                    anOverlappingIntervalPairs.add(list.get(i));
                    anOverlappingIntervalPairs.add(list.get(j));
                    listOverlappingIntervalPairs.add(anOverlappingIntervalPairs);
                }
            }
        }
        return listOverlappingIntervalPairs;
    }

    public boolean isOverlapping(IntervalPair firstPair, IntervalPair secondPair) {
        if (((firstPair.getStart() >= secondPair.getStart()) && (firstPair.getStart() <= secondPair.getEnd())) ||
                ((secondPair.getStart() >= firstPair.getStart()) && (secondPair.getStart() <= firstPair.getEnd()))) {
            return true;
        } else {
            return false;
        }
    }
}
