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
    public static int[] arrayPreviousLess(int[] items) {
        try {
            if (items.length < 3 || items.length > 15) {
                throw new IndexOutOfBoundsException();
            }
            for (int a : items) {
                if (a < 1 || a > 200) {
                    throw new ArrayStoreException();
                }
            }
            int[] result = new int[items.length];
            result[0] = -1;
            for (int i=1;i < items.length; i++) {
                int t = -1;
                for (int j=0;j < items.length - 1;j++) {
                    if (j < i) {
                        if (items[j] < items[i]) {
                            t = items[j];
                        }
                    }
                    else {
                        break;
                    }
                }
                result[i] = t;
            }
            return result;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Please init Array length between 3 ≤ items.length ≤ 15");
            e.printStackTrace();
            return new int[]{};
        }
        catch (ArrayStoreException e) {
            System.out.println("Please init values in Array between 1 ≤ items[i] ≤ 200");
            e.printStackTrace();
            return new int[]{};
        }
    }
}
