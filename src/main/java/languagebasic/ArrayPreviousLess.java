package languagebasic;

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
     * @throws CustomException if the input violates rules
     *          3 ≤ items.length ≤ 15
     *          1 ≤ items[i] ≤ 200
     */
    public int[] arrayPreviousLess(int[] items) throws CustomException {
        int size = items.length;
        if (size < 3 || size > 15) {
            throw new CustomException("invalid array length = " + size);
        }

        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            int current = items[i];
            if (current < 1 || current > 200) {
                throw new CustomException("array element [" + i + "] has invalid value = " + current);
            }

            int small = -1;
            for (int j = 0; j < i; j++) {
                if (items[j] < current) {
                    small = items[j];
                }
            }
            result[i] = small;
        }
        return result;
    }
}
