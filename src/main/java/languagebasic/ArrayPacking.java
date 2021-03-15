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
     * @throws CustomException if the input violates rules
     *          1 ≤ array.length ≤ 4
     *          0 ≤ array[i] < 256
     */
    public int arrayPacking(int[] array) throws CustomException {
        //TODO: create the CustomException class
        //TODO: implement this method
        //throw new UnsupportedOperationException("This method is not implemented yet");
        int i;
        if (!isArrayLengthValid(array)) {
            throw new CustomException("Invalid array length. Actual length: " + array.length + ". Expected length: 1 - 4");
        }

        StringBuilder binaryAppendFromArray = new StringBuilder();
        for (i = array.length - 1; i >= 0; i--) {
            if (isArrayElementValid(array[i])) {
                binaryAppendFromArray.append(String.format("%8s", Integer.toBinaryString(array[i])).replace(" ", "0"));
            }
            else {
                throw new CustomException("Invalid array elements. Expected value: 0 <= array[i] < 256");
            }
        }
        return Integer.parseUnsignedInt(String.valueOf(binaryAppendFromArray), 2);
    }

    private boolean isArrayLengthValid(int[] array) {
        return array.length >= 1 && array.length <= 4;
    }

    private boolean isArrayElementValid(int integer) {
        return integer >= 0 && integer < 256;
    }
}
