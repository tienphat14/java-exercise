package languagebasic;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OverlappingIntervalPairsTest {
    private static final String OVERLAPPING_INTERVAL_PAIRS = "overlapPairs";

    OverlappingIntervalPairs overlappingIntervalPairsTest = new OverlappingIntervalPairs();

    @DataProvider(name = OVERLAPPING_INTERVAL_PAIRS)
    public Object[][] overlapIntervalProvider(){
        return new Object[][]{
                {new Interval[]{}}, //Empty interval
                {new Interval[]{new Interval(11, 15), new Interval(3, 9),
                        new Interval(1, 4), new Interval(15,18), new Interval(2, 7), new Interval(1, 20),
                        new Interval(20, 30), new Interval(40, 50), new Interval(20, 30)}}, // many overlapping interval
                {new Interval[]{new Interval(11, 15), new Interval(12, 14), new Interval(11, 15)}}
        };
    }

    @Test(dataProvider = OVERLAPPING_INTERVAL_PAIRS)
    public void getOverlappingIntervalPairs(Interval[] interval){
        System.out.println("===========================================================");
        System.out.println("Input intervals: ");
        String[] in = overlappingIntervalPairsTest.getInputIntervals(interval);
        for (String s: in){
            System.out.print(s + "; ");
        }

        System.out.println("\n\nOverlap Interval Pairs: ");
        String[] out = overlappingIntervalPairsTest.getAllOverlapPairs(interval);
        for (String s: out){
            System.out.println(s + ";");
        }
    }
}
