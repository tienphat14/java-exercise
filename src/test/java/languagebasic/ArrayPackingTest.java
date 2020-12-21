package languagebasic;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ArrayPackingTest {

    private static final String LENGTH_EXCEPTION_ARRAY = "lengthExceptionArray";
    private static final String VALUE_EXCEPTION_ARRAY = "valueExceptionArray";
    private static final String NORMAL_ARRAY = "normalArray";
    private static final String NEGATIVE_VALUE = "negativelArray";



    ArrayPacking arrayPackingTest = new ArrayPacking();


    @DataProvider(name = LENGTH_EXCEPTION_ARRAY)
    public Object[][] lengthExceptionArrayProvider(){
        return new Object[][]{
                {new int[]{}},
                {new int[]{1, 2, 3, 4, 5}}
        };
    }

    @DataProvider(name = VALUE_EXCEPTION_ARRAY)
    public Object[][] valueExceptionArrayProvider(){
        return new Object[][]{
                {new int[]{-1, 1, 2}},
                {new int[]{0, 256, 4, 5}}
        };
    }

    @DataProvider(name = NORMAL_ARRAY)
    public Object[][] normalExceptionArrayProvider(){
        return new Object[][]{
                {new int[]{-24, 85, 0}}
        };
    }

    @DataProvider(name = NEGATIVE_VALUE)
    public Object[][] negativeValueProvider(){
        return new Object[][]{
                {new int[]{0, 0, 0, 255}}
        };
    }

    @Test (dataProvider = LENGTH_EXCEPTION_ARRAY)
    public void getArrayPacking_LengthExceptionArray(int[] input){
        try {
            arrayPackingTest.arrayPacking(input);
        }
        catch(CustomException e){
            Assert.assertTrue(e.getMessage().contains("Array length must be from 1 to 4"));
        }
    }

    @Test (dataProvider = VALUE_EXCEPTION_ARRAY)
    public void getArrayPacking_ValueExceptionArray(int[] input){
        try {
            arrayPackingTest.arrayPacking(input);
        }
        catch(CustomException e){
            Assert.assertTrue(e.getMessage().contains("Array value must be from 0 to 255"));
        }
    }

    @Test (dataProvider = NORMAL_ARRAY)
    public void getArrayPacking_NormalExceptionArray(int[] input){
        try {
            int result = arrayPackingTest.arrayPacking(input);
            Assert.assertEquals( result, 21784);

        }
        catch(CustomException e){
            System.out.println(e.getMessage());
        }
    }

    @Test (dataProvider = NEGATIVE_VALUE)
    public void getArrayPacking_NegativeValue(int[] input){
        try {
            int result = arrayPackingTest.arrayPacking(input);
            Assert.assertEquals( result, -16777216);

        }
        catch(CustomException e){
            System.out.println(e.getMessage());
        }
    }
}