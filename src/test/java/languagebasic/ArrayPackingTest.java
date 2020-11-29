package languagebasic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayPackingTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayPackingTest.class);
    private static final String EMPTY_ARRAY = "emptyArray";
    private static final String SINGLE_ELEMENT_ARRAY = "singleElementArray";
    private static final String NORMAL_ARRAY = "normalArray";
    private static final String INVALID_ELEMENT = "invalidElement";
    private static final String INVALID_SIZE = "invalidSize";

    private static final String INVALID_SIZE_ERROR = "The array's size must be between 1 and 4!";
    private static final String INVALID_ELEMENT_ERROR = "The element must be equal or greater zero and less than 256!";

    private ArrayPacking arrayPacking = new ArrayPacking();

    @DataProvider(name = EMPTY_ARRAY)
    public Object[][] emptyArrayProvider() {
        return new Object[][] {
                {new int[]{}}
        };
    }

    @DataProvider(name = SINGLE_ELEMENT_ARRAY)
    public Object[][] singleElementArrayProvider() {
        return new Object[][] {
                {new int[] {100}}
        };
    }

    @DataProvider(name = NORMAL_ARRAY)
    public Object[][] normalArrayProvider() {
        return new Object[][] {
                {new int[] {24, 85, 0}}
        };
    }

    @DataProvider(name = INVALID_ELEMENT)
    public Object[][] invalidElementProvider() {
        return new Object[][] {
                {new int[] {256}},
                {new int[] {-1}},
        };
    }

    @DataProvider(name = INVALID_SIZE)
    public Object[][] allArraysProvider() {
        return new Object[][] {
                {new int[] {24, 85, 0, 4, 5}}
        };
    }

    @Test(dataProvider = EMPTY_ARRAY)
    public void getArrayPacking_emptyArray_returnErrorMessage(int[] availableArray) {
        try {
            int result = arrayPacking.arrayPacking(availableArray);
        } catch (CustomException e) {
            Assert.assertEquals(e.getErrorMessage(), INVALID_SIZE_ERROR);
        }
    }

    @Test(dataProvider = SINGLE_ELEMENT_ARRAY)
    public void getArrayPacking_singleElement_returnAnInteger(int[] availableArray) {
        try {
            int result = arrayPacking.arrayPacking(availableArray);
            Assert.assertEquals(result, 100);
        } catch (CustomException e) {
            System.out.println(e.getErrorMessage());
        }
    }

    @Test(dataProvider = NORMAL_ARRAY)
    public void getArrayPacking_normalArray_returnAnInteger(int[] availableArray) {
        try {
            int result = arrayPacking.arrayPacking(availableArray);
            Assert.assertEquals(result, 21784);
        } catch (CustomException e) {
            System.out.println(e.getErrorMessage());
        }
    }

    @Test(dataProvider = INVALID_ELEMENT)
    public void getArrayPacking_invalidElement_returnErrorMessage(int[] availableArray) {
        try {
            int result = arrayPacking.arrayPacking(availableArray);
        } catch (CustomException e) {
            Assert.assertEquals(e.getErrorMessage(), INVALID_ELEMENT_ERROR);
        }
    }

    @Test(dataProvider = INVALID_SIZE)
    public void getArrayPacking_invalidSize_returnErrorMessage(int[] availableArray) {
        try {
            int result = arrayPacking.arrayPacking(availableArray);
        } catch (CustomException e) {
            Assert.assertEquals(e.getErrorMessage(), INVALID_SIZE_ERROR);
        }
    }
}