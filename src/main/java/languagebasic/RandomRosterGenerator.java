package languagebasic;

import java.util.ArrayList;
import java.util.Random;

/**
 * Generate a random roster to review assignments =]]
 */
public class RandomRosterGenerator {
    /**
     * Get a roster from an array of available names. Duplication is allowed
     *
     * @param availableNames Array of available names
     * @param size Size of the roster you want to get
     * @return A roster with the desired size or empty if invalid input
     */
    public String[] getRandomRoster(String[] availableNames, int size) {
        if(size > availableNames.length || size <= 0)
            return new String[]{};
        ArrayList<Integer> list = getRandomNonRepeatingIntegers(size, 0, size);
        try {
            String[] listResult = new String[size];
            for (int i = 0; i < size; i++) {
                listResult[i] = availableNames[list.get(i)];
            }
            return listResult;
        }catch (Exception ex){
            return new String[]{};
        }
    }

    /**
     * get a random int form min to max
     * @param min min int
     * @param max max int
     * @return the random int
     */
    public int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Get the random int list from max to min with size of list
     * @param size size list
     * @param min min index
     * @param max max index
     * @return random array index not duplicate
     */
    public ArrayList<Integer> getRandomNonRepeatingIntegers(int size, int min,
                                                                   int max) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        while (numbers.size() < size) {
            int random = getRandomInt(min, max);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        return numbers;
    }
}