package languagebasic;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class OverlappingIntervalPairsTest {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(OverlappingIntervalPairsTest.class);

    private static final String EMPTY_LIST = "emptyList";
    private static final String NORMAL_LIST = "normalList";
    private static final String INVALID_SIZE = "invalidSize";

    private static final String INVALID_SIZE_ERROR = "The list is empty or has only one pair!";

    private OverlappingIntervalPairs overlappingIntervalPairs = new OverlappingIntervalPairs();

    @DataProvider(name = EMPTY_LIST)
    public Object[][] emptyList() {
        List<OverlappingIntervalPairs.IntervalPair> list = new ArrayList<>();
        return new Object[][] {
                {list}
        };
    }

    @DataProvider(name = INVALID_SIZE)
    public Object[][] invalidSize() {
        List<OverlappingIntervalPairs.IntervalPair> list = new ArrayList<>();
        OverlappingIntervalPairs.IntervalPair intervalPair = new OverlappingIntervalPairs.IntervalPair();
        list.add(new OverlappingIntervalPairs.IntervalPair(1, 2));
        return new Object[][] {
                {list}
        };
    }

    @DataProvider(name = NORMAL_LIST)
    public Object[][] normalList() {
        List<OverlappingIntervalPairs.IntervalPair> list = new ArrayList<>();
        list.add(new OverlappingIntervalPairs.IntervalPair(11, 15));
        list.add(new OverlappingIntervalPairs.IntervalPair(3, 9));
        list.add(new OverlappingIntervalPairs.IntervalPair(1, 4));
        list.add(new OverlappingIntervalPairs.IntervalPair(15, 18));
        System.out.println("normal");
        return new Object[][] {
                {list}
        };
    }

    @Test(dataProvider = EMPTY_LIST)
    public void getOverlappingIntervalPairs_emptyList_returnErrorMessage(List<OverlappingIntervalPairs.IntervalPair> availableList) {
        try {
            List<List<OverlappingIntervalPairs.IntervalPair>> result = overlappingIntervalPairs.getOverlappingIntervalPairs(availableList);
        } catch (CustomException e) {
            Assert.assertEquals(e.getErrorMessage(), INVALID_SIZE_ERROR);
        }
    }

    @Test(dataProvider = INVALID_SIZE)
    public void getOverlappingIntervalPairs_invalidSize_returnErrorMessage(List<OverlappingIntervalPairs.IntervalPair> availableList) {
        try {
            List<List<OverlappingIntervalPairs.IntervalPair>> result = overlappingIntervalPairs.getOverlappingIntervalPairs(availableList);
        } catch (CustomException e) {
            Assert.assertEquals(e.getErrorMessage(), INVALID_SIZE_ERROR);
        }
    }

    @Test(dataProvider = NORMAL_LIST)
    public void getOverlappingIntervalPairs_normalList_returnResult(List<OverlappingIntervalPairs.IntervalPair> availableList) {
        try {
            List<List<OverlappingIntervalPairs.IntervalPair>> result = overlappingIntervalPairs.getOverlappingIntervalPairs(availableList);
            //Print the overlapping interval pairs
            for (int i = 0; i < result.size(); i++) {
                System.out.println("Pair " + i + ":");
                System.out.print("[" + result.get(i).get(0).getStart() + "," + result.get(i).get(0).getEnd()+"]");
                System.out.println(" and [" + result.get(i).get(1).getStart() + "," + result.get(i).get(1).getEnd() +"]");
            }
            Assert.assertEquals(result.get(0).get(0).getStart(), 11);
            Assert.assertEquals(result.get(0).get(0).getEnd(), 15);
            Assert.assertEquals(result.get(0).get(1).getStart(), 15);
            Assert.assertEquals(result.get(0).get(1).getEnd(), 18);

            Assert.assertEquals(result.get(1).get(0).getStart(), 3);
            Assert.assertEquals(result.get(1).get(0).getEnd(), 9);
            Assert.assertEquals(result.get(1).get(1).getStart(), 1);
            Assert.assertEquals(result.get(1).get(1).getEnd(), 4);
        } catch (CustomException e) {
            System.out.println(e.getErrorMessage());
        }
    }
}
