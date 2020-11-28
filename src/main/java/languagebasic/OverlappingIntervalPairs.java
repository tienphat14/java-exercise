package languagebasic;
import java.util.Arrays;

public class OverlappingIntervalPairs {
    /*
    Given a collection of intervals (an interval is defined by start and end property), implement a method to return all overlapping interval pairs.
    Example:
    Given [11, 15], [3, 9], [1, 4], [15, 18] => return [11, 15] and [15, 18], [3, 9] and [1, 4].
    Given [1, 5], [6, 8], [5, 12], [2, 6] => return [1, 5] and [5, 12], [1, 5] and [2, 6], [6, 8] and [5, 12], [5, 12] and [2, 6]
     */

    /**
     * get the array couple that overlap
     * @param items the array input
     * @return the array couple overlap
     */
    public int[][][] getTheCoupleArrayOverlapRange(int[][] items){
        int length = getLengthArray(items.length);
        int[][][] results = new int[length][2][2];
        int index = 0;
        for(int i=0; i < items.length; i++){
            int[] intArray1 = items[i];
            for(int j=i+1; j < items.length; j++){
                int[] intArray2 = items[j];
                if(isOverlap(intArray1, intArray2)){
                    results[index][0] = intArray1;
                    results[index++][1] = intArray2;
                }
            }
        }
        return Arrays.copyOf(results,index);
    }

    /**
     * Check the array 1 and array 2 overlap
     * @param array1 array 1 input
     * @param array2 array 2 input
     * @return true if overlap and else is false
     */
    public boolean isOverlap(int[] array1, int[] array2){
        if(array1[0] >= array2[0] && array1[0] <= array2[1])
            return true;
        if(array2[0] >= array1[0] && array2[0] <= array1[1])
            return true;
        return false;
    }

    /**
     * Check array follow the rule is a number range, start number and end number
     * start number is less or equal than end number
     * @param array the array input
     * @return true if correct and else
     */
    public boolean isArrayViolates(int[] array){
        if(array[1] >= array[0])
            return true;
        return false;
    }

    /**
     * Get the max length of the array
     * @param n length of array
     * @return the max length
     */
    public int getLengthArray(int n) {
        return (n * (n -1))/2;
    }

}
