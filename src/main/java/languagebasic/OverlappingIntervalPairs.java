package languagebasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class OverlappingIntervalPairs {
    /*
    Given a collection of intervals (an interval is defined by start and end property), implement a method to return all overlapping interval pairs.
    Example:
    Given [11, 15], [3, 9], [1, 4], [15, 18] => return [11, 15] and [15, 18], [3, 9] and [1, 4].
    Given [1, 5], [6, 8], [5, 12], [2, 6] => return [1, 5] and [5, 12], [1, 5] and [2, 6], [6, 8] and [5, 12], [5, 12] and [2, 6]
     */

    public void overlappingIntervalPairs(int[][] givenIntegers) {
        List<Interval> givenIntervalsList = new ArrayList<>();
        for (int[] givenInteger : givenIntegers) {
            givenIntervalsList.add(new Interval(givenInteger[0], givenInteger[1]));
        }
        List<Interval> givenIntervalsListWithoutDup = givenIntervalsList.stream().distinct().collect(Collectors.toList());
        ArrayList<String> listOfOverlappingIntervalPairs = new ArrayList<>();
        for (int i = 0; i < givenIntervalsListWithoutDup.size(); i++) {
            for (int j = i + 1; j < givenIntervalsListWithoutDup.size(); j++) {
                if (isOverlapped(givenIntervalsListWithoutDup.get(i), givenIntervalsListWithoutDup.get(j))) {
                    listOfOverlappingIntervalPairs.add("[" + givenIntervalsListWithoutDup.get(i).start + ", " + givenIntervalsListWithoutDup.get(i).end
                            + "] and [" + givenIntervalsListWithoutDup.get(j).start + "," + givenIntervalsListWithoutDup.get(j).end + "]");
                }
            }
        }
        for (String l : listOfOverlappingIntervalPairs) {
            System.out.println(l);
        }
    }

    private boolean isOverlapped(Interval firstInterval, Interval secondInterval) {
        return isThe2ndIntervalStartBetweenThe1stInterval(firstInterval, secondInterval) || isThe1stIntervalStartBetweenThe2ndInterval(firstInterval, secondInterval);
    }

    private boolean isThe2ndIntervalStartBetweenThe1stInterval(Interval firstInterval, Interval secondInterval) {
        return (secondInterval.getStart() >= firstInterval.getStart()) && (secondInterval.getStart() <= firstInterval.getEnd());
    }

    private boolean isThe1stIntervalStartBetweenThe2ndInterval(Interval firstInterval, Interval secondInterval) {
        return (firstInterval.getStart() >= secondInterval.getStart()) && (firstInterval.getStart() <= secondInterval.getEnd());
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

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Interval) {
                return ((Interval) obj).start == start && ((Interval) obj).end == end;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.start;
        }
    }
}

