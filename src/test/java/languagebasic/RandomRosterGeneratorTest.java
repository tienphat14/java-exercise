package languagebasic;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RandomRosterGeneratorTest {

    private static final String EMPTY_ARRAY = "emptyArray";
    private static final String SINGLE_ELEMENT_ARRAY = "singleElementArray";
    private static final String NORMAL_ARRAY = "normalArray";
    private static final String ALL_ARRAYS = "allArray";
    private RandomRosterGenerator randomRosterGenerator = new RandomRosterGenerator();

    @DataProvider(name = EMPTY_ARRAY)
    public Object[][] emptyArrayProvider() {
        return new Object[][]{
                {new String[]{}}
        };
    }

    @DataProvider(name = SINGLE_ELEMENT_ARRAY)
    public Object[][] singleElementArrayProvider() {
        return new Object[][]{
                {new String[]{"Dai"}}
        };
    }

    @DataProvider(name = NORMAL_ARRAY)
    public Object[][] normalArrayProvider() {
        return new Object[][]{
                {new String[]{"Dai", "Ha", "Hung", "Liem", "Nhon", "Quang", "Triet", "Tuyen", "Vu"}}
        };
    }

    @DataProvider(name = ALL_ARRAYS)
    public Object[][] allArrayProvider() {
        return new Object[][]{
                {new String[]{}},
                {new String[]{"Dai"}},
                {new String[]{"Dai", "Ha", "Hung", "Liem", "Nhon", "Quang", "Triet", "Tuyen", "Vu"}}
        };
    }

    @Test(dataProvider = ALL_ARRAYS)
    public void getRandomRoster_negativeSize_returnEmpty(String[] availableNames) {
        String[] result = randomRosterGenerator.getRandomRoster(availableNames, -1);
        Assert.assertEquals(result.length, 0);
    }

    @Test(dataProvider = ALL_ARRAYS)
    public void getRandomRoster_zeroSize_returnEmpty(String[] availableNames) {
        String[] result = randomRosterGenerator.getRandomRoster(availableNames, 0);
        Assert.assertEquals(result.length, 0);
    }

    @Test(dataProvider = EMPTY_ARRAY)
    public void getRandomRoster_emptyArray_returnEmpty(String[] availableNames) {
        String[] result = randomRosterGenerator.getRandomRoster(availableNames, 3);
        Assert.assertEquals(result.length, 0);
    }

    @Test(dataProvider = SINGLE_ELEMENT_ARRAY)
    public void getRandomRoster_singleElementArray_returnDuplicationOfSingleName(String[] availableNames) {
        String[] result = randomRosterGenerator.getRandomRoster(availableNames, 3);
        Assert.assertEquals(result.length, 3);
        Assert.assertEquals(result[1], result[0]);
        Assert.assertEquals(result[2], result[0]);
    }

    @Test(dataProvider = NORMAL_ARRAY)
    public void getRandomRoster_normalArray_returnRosterWithDesignedSize(String[] availableNames) {
        String[] result = randomRosterGenerator.getRandomRoster(availableNames, 5);
        Assert.assertEquals(result.length, 5);
    }
}