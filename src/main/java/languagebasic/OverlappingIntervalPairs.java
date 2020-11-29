package languagebasic;

import java.util.*;

public class OverlappingIntervalPairs {
    /*
    Given a collection of intervals (an interval is defined by start and end property), implement a method to return all overlapping interval pairs.
    Example:
    Given [11, 15], [3, 9], [1, 4], [15, 18] => return [11, 15] and [15, 18], [3, 9] and [1, 4].
    Given [1, 5], [6, 8], [5, 12], [2, 6] => return [1, 5] and [5, 12], [1, 5] and [2, 6], [6, 8] and [5, 12], [5, 12] and [2, 6]
     */

    public String getResultOverlappingArray(int[][] inputArrays) {
        List<String> resultString = new ArrayList<>();
        for (int i = 0; i <= inputArrays.length-1; i++) {
            int[] previousArray = inputArrays[i];
            for (int j = i + 1; j <= inputArrays.length-1; j++) {
                int[] afterArray = inputArrays[j];
                if (previousArray[0] <= afterArray[0] && afterArray[0] <= previousArray[1] && previousArray[1] <= afterArray[1]) {
                    resultString.add(toString(previousArray, afterArray));
                }
                else if (afterArray[0] <= previousArray[0] && previousArray[0] <= afterArray[1] && afterArray[1] <= previousArray[1]) {
                    resultString.add(toString(previousArray, afterArray));
                }
                else if (previousArray[0] <= afterArray[0] && afterArray[0] <= afterArray[1] && afterArray[1] <= previousArray[1]) {
                    resultString.add(toString(previousArray, afterArray));
                }
                else if (afterArray[0] <= previousArray[0] && previousArray[0] <= previousArray[1] && previousArray[1] <= afterArray[1]) {
                    resultString.add(toString(previousArray, afterArray));
                }
            }
        }
        return resultString.toString();
    }

    private String toString(int[] a, int[] b){
            return Arrays.toString(a) + " and " + Arrays.toString(b);
    }
}
