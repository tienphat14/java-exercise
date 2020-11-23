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
     * @throws CustomException if the input violates rules
     *          3 ≤ items.length ≤ 15
     *          1 ≤ items[i] ≤ 200
     */
    public int[] arrayPreviousLess(int[] items)  {
        int[] result = new int[items.length];
        if(items.length <3 || items.length >15)
            try {
                throw new InputViolatesRulesException("Invalid input. please try again");
            } catch (InputViolatesRulesException exception) {
                //do no thing
            }

        for (int i = 0; i < items.length; i++) {
            int substitute = -1;
            for (int j = 0; j < i; j++) {
                if (items[j] < items[i]) {
                    substitute = items[j];
                }
            }
            result[i] = substitute;
        }


        return result;
    }
}
