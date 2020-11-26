package languagebasic;

import org.junit.Assert;
import org.junit.Test;

public class ArrayPackingTest {
    //TODO: Write tests for your code
    @Test(expected = CustomException.class)
    public void givenArrInt_whenLengthNotSatisfied_thenThrowException() throws CustomException {
        ArrayPacking packing = new ArrayPacking();
        int[] arr = {1, 2, 3, 4, 5};
        packing.arrayPacking(arr);
    }

    @Test(expected = CustomException.class)
    public void givenArrInt_whenElementNotInRange_thenThrowException() throws CustomException {
        ArrayPacking packing = new ArrayPacking();
        int[] arr = {0, 2, 4, 256};
        packing.arrayPacking(arr);
    }

    @Test
    public void givenArrInt_whenValid_thenReturnResult() throws CustomException {
        ArrayPacking packing = new ArrayPacking();
        int[] arr = {24, 85, 0};
        Assert.assertEquals(packing.arrayPacking(arr), 21784);
    }
}