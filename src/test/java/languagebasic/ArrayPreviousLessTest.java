package languagebasic;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ArrayPreviousLessTest {
    private static final String EMPTY_ARRAY = "emptyArray";
    private static final String LENGTH_EXCEPTION_ARRAY = "lengthExceptionArray";
    private static final String VALUE_EXCEPTION_ARRAY = "valueExceptionArray";
    private static final String NORMAL_ARRAY = "normalArray";

    ArrayPreviousLess arrayPreviousLessTest = new ArrayPreviousLess();


    @DataProvider(name = EMPTY_ARRAY)
    public Object[][] emptyArrayProvider(){
        return new Object[][]{
                {new int[]{}}
        };
    }

    @DataProvider(name = LENGTH_EXCEPTION_ARRAY)
    public Object[][] lengthArrayProvider(){
        return new Object[][]{
                {new int[]{2, 3}},
                {new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,}}
        };
    }

    @DataProvider(name = VALUE_EXCEPTION_ARRAY)
    public Object[][] valueArrayProvider(){
        return new Object[][]{
                {new int[]{2, 3, 0, 200}},
                {new int[]{0, 1,1,1}}
        };
    }

    @DataProvider(name = NORMAL_ARRAY)
    public Object[][] normalArrayProvider(){
        return new Object[][]{
                {new int[]{4, 2, 3, 5, 5, 9, 7, 1}}
        };
    }

    @Test(dataProvider = EMPTY_ARRAY)
    public void getArrayPreviousLess_EmptyArray(int[] input){
        try {
            arrayPreviousLessTest.arrayPreviousLess(input);
        }
        catch(CustomException e){
            Assert.assertTrue(e.getMessage().contains("Number of items must be from 3 to 15"));
        }
    }

    @Test(dataProvider = LENGTH_EXCEPTION_ARRAY)
    public void getArrayPreviousLess_LengthExceptionArray(int[] input){
        try {
            arrayPreviousLessTest.arrayPreviousLess(input);
        }
        catch(CustomException e){
            Assert.assertTrue(e.getMessage().contains("Number of items must be from 3 to 15"));
        }
    }

    @Test(dataProvider = VALUE_EXCEPTION_ARRAY)
    public void getArrayPreviousLess_valueExceptionArray(int[] input){
        try {
            arrayPreviousLessTest.arrayPreviousLess(input);
        }
        catch(CustomException e){
            Assert.assertTrue(e.getMessage().contains("Item value must be from 1 to 200"));
        }
    }

    @Test(dataProvider = NORMAL_ARRAY)
    public void getArrayPreviousLess_normalArray(int[] input){
        try {
            int[] results = arrayPreviousLessTest.arrayPreviousLess(input);
            Assert.assertTrue(Arrays.equals(results, new int[]{-1, -1, 2, 3, 3, 5, 5, -1}));
        }
        catch (CustomException e){
            System.out.println(e.getMessage());
        }
    }

}