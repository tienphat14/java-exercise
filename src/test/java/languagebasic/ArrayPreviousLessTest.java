package languagebasic;

import org.junit.Assert;
import org.junit.Test;

public class ArrayPreviousLessTest {
    //TODO: Write tests for your code

    @Test(expected = CustomException.class)
    public void givenArrInt_whenArrLengthNotValid_thenThrowException() throws CustomException {
        int[] arr = new int[15];
        ArrayPreviousLess arrPrev = new ArrayPreviousLess();
        arrPrev.arrayPreviousLess(arr);
    }

    @Test(expected = CustomException.class)
    public void givenArrInt_whenElementNotInRange_thenThrowException() throws CustomException {
        int[] arr = {0, 1, 2, 3};
        ArrayPreviousLess arrPrev = new ArrayPreviousLess();
        arrPrev.arrayPreviousLess(arr);
    }

    @Test
    public void givenArrInt_whenValid_thenReturnResult() throws CustomException {
        int[] arr = {3, 5, 2, 4, 5};
        ArrayPreviousLess arrPrev = new ArrayPreviousLess();
        int[] calculated = arrPrev.arrayPreviousLess(arr);
        int[] rst = {-1, 3, -1, 2, 4};
        for (int idx = 0; idx < arr.length; idx++)
            Assert.assertEquals(calculated[idx], rst[idx]);
    }
}