package languagebasic;

/**
 * Given array of integers, for each position i,
 * search among the previous positions for the last (from the left) position that contains a smaller value.
 * Store this value at position i in the answer. If no such value can be found, store -1 instead.
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
        if(items.length < 3 || items.length > 15)
            throw new CustomException("The input break the rule items.length between 3 to 15");
        int[] results = new int[items.length];
        for(int i = 0; i < items.length; i++){
            results[i] = getPreviousNumberSmaller(items, i);
        }
        return results;
    }
    public int getPreviousNumberSmaller(int[] items, int currentPosition){
        int currentItemVal = items[currentPosition];
        for(int i = currentPosition -1 ; i>=0 ; i--){
            if(items[i] < currentItemVal)
                return items[i];
        }
        return -1;
    }
}
