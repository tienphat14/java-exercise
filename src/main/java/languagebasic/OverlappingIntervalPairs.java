package languagebasic;

import java.util.*;

public class OverlappingIntervalPairs {
    /*
    Given a collection of intervals (an interval is defined by start and end property), implement a method to return all overlapping interval pairs.
    Example:
    Given [11, 15], [3, 9], [1, 4], [15, 18] => return [11, 15] and [15, 18], [3, 9] and [1, 4].
    Given [1, 5], [6, 8], [5, 12], [2, 6] => return [1, 5] and [5, 12], [1, 5] and [2, 6], [6, 8] and [5, 12], [5, 12] and [2, 6]
     */

    /**
     * Get Overlapping Interval Pairs
     * Version 1
     * @param arrays Arrays
     */
    public static List<String> getOverlappingIntervalPairs(int[][] arrays) {
        List<int[][]> result = new ArrayList<>();
        for (int i=0;i< arrays.length;i++) {
            for (int j=i+1;j<arrays.length;j++) {
                boolean isDup = false;
                int[] a = arrays[i];
                int[] b = arrays[j];
                if (a[0] <= b[1] && a[1] >= b[0]) {
                    for (int[][] c : result) {
                        if ((Arrays.equals(a, c[0]) && Arrays.equals(b, c[1])) ||
                                (Arrays.equals(a, c[1]) && Arrays.equals(b, c[0]))) {
                            isDup = true;
                            break;
                        }
                    }
                    if (!isDup) {
                        result.add(new int[][]{a, b});
                    }
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (int[][] out : result) {
            list.add(Arrays.toString(out[0]) + " and " + Arrays.toString(out[1]));
        }
        return list;
    }
}
