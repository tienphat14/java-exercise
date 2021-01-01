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
        //TODO: create the CustomException class
        //TODO: implement this method
        if (items.length < 3 || items.length > 15)
            throw new CustomException("Array length must be within 3 and 15");
        int[] rst = new int[items.length];
        for (int idx = 0; idx < items.length; idx++) {
            if (items[idx] < 1 || items[idx] > 200)
                throw new CustomException("Value at index " + idx + " (" + items[idx] + ") must be within [1, 200]");
            for (int reverseIdx = idx - 1; reverseIdx > -1; reverseIdx--) {
                if (items[reverseIdx] < items[idx]) {
                    rst[idx] = items[reverseIdx];
                    break;
                }
            }
            if (rst[idx] == 0)
                rst[idx] = -1;
        }
        return rst;
    }
}
