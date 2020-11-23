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

    /**
     *
     * @param array An array of up to four non-negative integers, each less than 256
     * @return The obtained integer packed from given array
     * @throws NumberFormatException if the input violates rules
     *          1 ≤ array.length ≤ 4
     *          0 ≤ array[i] < 256
     */
    public int arrayPacking(int[] array) {
        String s = "";
        try{
            if (array.length <1 || array.length > 4) {
                throw new NumberFormatException();
            }
            condition:
            while (true) {
                for(int i =0; i< array.length; i++) {
                    if(array[i] < 0) {
                        System.out.println("Please enter 0 <= array[i]");
                        throw new NumberFormatException();
                    }
                    if(array[i] >=256) {
                        System.out.println("Please enter array[i] < 256");
                        throw new NumberFormatException();
                    }
                    s += getBinary(array[i]);
                    System.out.println("DEBUG ONLY: >>> " +array[i]+", The binary given = " +s);
                    if(i == 0) { break condition; }
                }

            }
        } catch (NumberFormatException nfe){
            System.out.println("MESSAGE: The input violates rules: "+ nfe);
            return 0;
        }
        return Integer.parseInt(s, 2);
    }

    private static String getBinary(int val) {
        String s = "";
        while (val>= 0){
            for(int i = 0; i < 8; i++) {
                if(val % 2 == 1)
                    s = 1 + s;
                else if(val % 2 == 0)
                    s = 0 + s;

                val = val/2;
            }
        }
        return s;
    }
}
