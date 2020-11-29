package languagebasic;

import java.util.InputMismatchException;

/**
 * Given array of integers, for each position i, search among the previous positions for the last (from the left) position that contains a smaller value. Store this value at position i in the answer. If no such value can be found, store -1 instead.
 *
 * Example
 *
 * For items = [3, 5, 2, 4, 5], the output should be
 * arrayPreviousLess(items) = [-1, 3, -1, 2, 4]
 */
public class ArrayPreviousLess {

    /**
     *
     * @param items Non-empty array of positive integers
     * @return Array containing answer values computed
     * @throws //CustomException if the input violates rules
     *          3 ≤ items.length ≤ 15
     *          1 ≤ items[i] ≤ 200
     */
    public int[] arrayPreviousLess(int[] arrays) {
        int[] result = new int[arrays.length];
        if(arrays.length <3 || arrays.length >15) throw new InputMismatchException("Invalid input. please try again");

        for (int i = 0; i < arrays.length; i++) {
            int flagFoundLess = -1;
            for (int j = 0; j < i; j++) {
                int before = arrays[j];
                int current = arrays[i];
                if (before < current) {
                    flagFoundLess = before;
                }
            }
            result[i] = flagFoundLess;
        }
        return result;
    }
}
