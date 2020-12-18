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
        if (items == null) {
            throw new CustomException("The array is null!");
        }

        if (items.length >= 3 && items.length <= 15) {
            int[] arrayPreviousLess = new int[items.length];

            if (items[0] < 1 || items[0] > 200) {
                throw new CustomException("The element must be from 1 to 200!");
            }

            arrayPreviousLess[0] = -1;
            for (int i = 1; i < items.length; i++) {
                if (items[i] >= 1 && items[i] <= 200) {
                    for (int j = i - 1; j >= 0; j--) {
                        if (items[i] < items[j]) {
                            arrayPreviousLess[i] = -1;
                            break;
                        } else if (items[i] > items[j]) {
                            arrayPreviousLess[i] = items[j];
                            break;
                        }
                    }
                } else {
                    throw new CustomException("The element must be from 1 to 200!");
                }
            }
            return arrayPreviousLess;
        } else {
            throw new CustomException("The array's size must be between 3 and 15!");
        }
    }
}
