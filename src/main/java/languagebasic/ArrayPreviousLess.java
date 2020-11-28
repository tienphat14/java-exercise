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
    private int[] arrayPreviousLess(int[] items) throws CustomException {
        if (items.length < 3 || items.length > 15){
            throw new CustomException("Number of items must be from 3 to 15. Number of items :" + items.length);
        }

        int[] result = new int[items.length];
        for (int i=0; i<items.length; i++){
            if (items[i] < 1 || items[i]>200){
                throw new CustomException("Item value must be from 1 to 200. Invalid value: " + items[i]);
            }

            int elementResult = -1;
            for (int j=0; j<i; j++){
                if (items[j]<items[i]){
                    elementResult = items[j];
                }
            }
            result[i] = elementResult;
        }
        return result;

       // throw new UnsupportedOperationException("This method is not implemented yet");
    }

    public static void main(String[] args) {

        ArrayPreviousLess arr = new ArrayPreviousLess();
        int[] test = {3, 5, 2, 4, 200};
        int[] result;
        try {
            result = arr.arrayPreviousLess(test);
            for (int item: result){
                System.out.println(item);
            }
        }catch(CustomException err){
            System.out.println(err);
        }

    }
}
