package languagebasic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayPreviousLessTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayPackingTest.class);
    private static final String EMPTY_ARRAY = "emptyArray";
    private static final String SINGLE_ELEMENT_ARRAY = "singleElementArray";
    private static final String NORMAL_ARRAY = "normalArray";
    private static final String INVALID_ELEMENT = "invalidElement";
    private static final String INVALID_SIZE = "invalidSize";

    private static final String INVALID_SIZE_ERROR = "The array's size must be between 3 and 15!";
    private static final String INVALID_ELEMENT_ERROR = "The element must be from 1 to 200!";

    private ArrayPreviousLess arrayPreviousLess = new ArrayPreviousLess();

    @DataProvider(name = EMPTY_ARRAY)
    public Object[][] emptyArrayProvider() {
        return new Object[][] {
                {new int[]{}}
        };
    }

    @DataProvider(name = SINGLE_ELEMENT_ARRAY)
    public Object[][] singleElementArrayProvider() {
        return new Object[][] {
                {new int[] {3}}
        };
    }

    @DataProvider(name = NORMAL_ARRAY)
    public Object[][] normalArrayProvider() {
        return new Object[][] {
                {new int[] {3, 5, 2, 4, 4, 5}}
        };
    }

    @DataProvider(name = INVALID_ELEMENT)
    public Object[][] invalidElementProvider() {
        return new Object[][] {
                {new int[] {-1, 2, 3}},
                {new int[] {1, 0, 3}},
                {new int[] {1, 2, 201}},
        };
    }

    @DataProvider(name = INVALID_SIZE)
    public Object[][] allArraysProvider() {
        return new Object[][] {
                {new int[] {1, 2}},
                {new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}}
        };
    }

    @Test(dataProvider = EMPTY_ARRAY)
    public void getArrayPreviousLess_emptyArray_returnErrorMessage(int[] availableArray) {
        try {
            int[] result = arrayPreviousLess.arrayPreviousLess(availableArray);
        } catch (CustomException e) {
            Assert.assertEquals(e.getErrorMessage(), INVALID_SIZE_ERROR);
        }
    }

    @Test(dataProvider = SINGLE_ELEMENT_ARRAY)
    public void getArrayPreviousLess_singleElement_returnAnInteger(int[] availableArray) {
        try {
            int[] result = arrayPreviousLess.arrayPreviousLess(availableArray);
            Assert.assertEquals(result[0], -1);
        } catch (CustomException e) {
            System.out.println(e.getErrorMessage());
        }
    }

    @Test(dataProvider = NORMAL_ARRAY)
    public void getArrayPreviousLess_normalArray_returnAnInteger(int[] availableArray) {
        try {
            int[] result = arrayPreviousLess.arrayPreviousLess(availableArray);
            Assert.assertEquals(result[0], -1);
            Assert.assertEquals(result[1], 3);
            Assert.assertEquals(result[2], -1);
            Assert.assertEquals(result[3], 2);
            Assert.assertEquals(result[4], 2);
            Assert.assertEquals(result[5], 4);
        } catch (CustomException e) {
            System.out.println(e.getErrorMessage());
        }
    }

    @Test(dataProvider = INVALID_ELEMENT)
    public void getArrayPreviousLess_invalidElement_returnErrorMessage(int[] availableArray) {
        try {
            int[] result = arrayPreviousLess.arrayPreviousLess(availableArray);
        } catch (CustomException e) {
            Assert.assertEquals(e.getErrorMessage(), INVALID_ELEMENT_ERROR);
        }
    }

    @Test(dataProvider = INVALID_SIZE)
    public void getArrayPreviousLess_invalidSize_returnErrorMessage(int[] availableArray) {
        try {
            int[] result = arrayPreviousLess.arrayPreviousLess(availableArray);
        } catch (CustomException e) {
            Assert.assertEquals(e.getErrorMessage(), INVALID_SIZE_ERROR);
        }
    }


}