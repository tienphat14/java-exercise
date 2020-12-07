package languagebasic;

import java.util.*;
import java.util.stream.Collectors;

public class OverlappingIntervalPairs {
    /*
    Given a collection of intervals (an interval is defined by start and end property), implement a method to return all overlapping interval pairs.
    Example:
    Given [11, 15], [3, 9], [1, 4], [15, 18] => return [11, 15] and [15, 18], [3, 9] and [1, 4].
    Given [1, 5], [6, 8], [5, 12], [2, 6] => return [1, 5] and [5, 12], [1, 5] and [2, 6], [6, 8] and [5, 12], [5, 12] and [2, 6]
     */

        public void overlappingIntervalPairs(int[][] givenIntegers) {
            ArrayList<Interval> intervalsList = new ArrayList<>();
            for (int[] givenInteger : givenIntegers) {
                intervalsList.add(new Interval(givenInteger[0], givenInteger[1]));
            }

            ArrayList<String> listOfOverlappingIntervalPairs = new ArrayList<>();
            for (int i = 0; i < intervalsList.size(); i++) {
                for (int j = i + 1; j < intervalsList.size(); j++) {
                    if (isOverlapped(intervalsList.get(i), intervalsList.get(j))) {
                        if (!listOfOverlappingIntervalPairs.contains(printIntervalPair(intervalsList.get(i), intervalsList.get(j)))) {
                            listOfOverlappingIntervalPairs.add(printIntervalPair(intervalsList.get(i), intervalsList.get(j)));
                        }
                    }
                }
            }

            for (String l : listOfOverlappingIntervalPairs) {
                System.out.println(l);
            }
        }

        private boolean isOverlapped(Interval firstInterval, Interval secondInterval) {
            return (secondInterval.getEnd() >= firstInterval.getStart()) && (secondInterval.getStart() <= firstInterval.getEnd());
        }

        private String printInterval(Interval interval) {
            return "[" + interval.getStart() + ", " + interval.getEnd() + "]";
        }

        private String printIntervalPair(Interval a, Interval b) {
            if (a.start <= b.start) {
                return printInterval(a) + " and " + printInterval(b);
            }
            else {
                return printInterval(b) + " and " + printInterval(a);
            }
        }


    static class Interval {
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return this.start;
        }

        public int getEnd() {
            return this.end;
        }
    }
}