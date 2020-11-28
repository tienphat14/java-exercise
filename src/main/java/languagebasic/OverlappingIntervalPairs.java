package languagebasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappingIntervalPairs {
    /*
    Given a collection of intervals (an interval is defined by start and end property), implement a method to return all overlapping interval pairs.
    Example:
    Given [11, 15], [3, 9], [1, 4], [15, 18] => return [11, 15] and [15, 18], [3, 9] and [1, 4].
    Given [1, 5], [6, 8], [5, 12], [2, 6] => return [1, 5] and [5, 12], [1, 5] and [2, 6], [6, 8] and [5, 12], [5, 12] and [2, 6]
     */

    public static void getOverlappingIntervalPairs(int[][] arrays) {
        List<StringBuilder> result = new ArrayList<>();
        for (int i=0;i< arrays.length;i++) {
            for (int j=i+1;j<arrays.length;j++) {
                int[] a = arrays[i];
                int[] b = arrays[j];
                if (a[0] <= b[1] && a[1] >= b[0]) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(Arrays.toString(a)).append(" and ").append(Arrays.toString(b));
                    result.add(stringBuilder);
                }
            }
        }
        System.out.println(result.toString());
    }
}
