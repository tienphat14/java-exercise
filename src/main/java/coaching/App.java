package coaching;

import languagebasic.ArrayPreviousLess;
import languagebasic.OverlappingIntervalPairs;
import languagebasic.RandomRosterGenerator;

import java.util.Arrays;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        System.out.println(Arrays.toString(ArrayPreviousLess.arrayPreviousLess(new int[]{2, 201, 4, 5, 7, 1})));
        String[] availableNames = new String[]{"Ben", "Tuan", "Nam", "Phu", "Dai", "Phat"};
        System.out.println(Arrays.toString(new RandomRosterGenerator().getRandomRoster(availableNames, -1)));
        int[][] arrays = new int[][]{{1, 5}, {6, 8}, {5, 12}, {2, 6}};
        OverlappingIntervalPairs.getOverlappingIntervalPairs(arrays);
    }
}
