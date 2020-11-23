package languagebasic;

/**
 * You are given an array of up to four non-negative integers, each less than 256.
 * Your task is to pack these integers into one number M in the following way:
 *  - The first element of the array occupies the first 8 bits of M;
 *  - The second element occupies next 8 bits, and so on.
 * Return the obtained integer M.
 *
 * Note: the phrase "first bits of M" refers to the least significant bits of M - the right-most bits of an integer. For further clarification see the following example.
 *
 * For a = [24, 85, 0], the output should be
 * arrayPacking(a) = 21784.
 *
 * An array [24, 85, 0] looks like [00011000, 01010101, 00000000] in binary.
 * After packing these into one number we get 00000000 01010101 00011000 (spaces are placed for convenience), which equals to 21784
 */
public class ArrayPacking {

//     **
//     *
//     * @param array An array of up to four non-negative integers, each less than 256
//     * @return The obtained integer packed from given array
//     * @throws CustomException if the input violates rules
//     *          1 ≤ array.length ≤ 4
//     *          0 ≤ array[i] < 256
//     */

    public static void main(String args[]) {
        int[] myIntArray = new int[]{24, 85, 0};
        int result = arrayPacking(myIntArray);
        System.out.println("*************");
        System.out.println(result);
    }

    /**
     * Get the packing number
     * @param array the array input
     * @return packing number
     */
    public static int arrayPacking(int[] array) {
        if(array.length <=0)
            return -1;
        try {
            String s = "";
            for(int i = array.length-1; i >= 0; i--) {
                s += getBinary(array[i]);
            }
            return Integer.parseInt(s, 2);
        }catch (Exception ex){
            return -1;
        }
    }

    /**
     * Get binary of integer
     * @param val input value
     * @return the bit string of integer
     */
    public static String getBinary(int val) {
        String s = "";
        for(int i = 0; i < 8; i++) {
            if(val % 2 == 1)
                s = 1 + s;
            else if(val % 2 == 0)
                s = 0 + s;

            val = val/2;
        }

        return s;
    }

    /**
     * Class CustomException if the input violates rules
     *           1 ≤ array.length ≤ 4
     *           0 ≤ array[i] < 256
     */
    public class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }

}
