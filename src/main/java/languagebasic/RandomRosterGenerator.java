package languagebasic;

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
        int length = availableNames.length;
        if (availableNames == null || length == 0 || size <= 0) {
            return new String[]{};
        }
        String[] listResult = new String[size];
        for (int i = 0; i < size; i++) {
            listResult[i] = availableNames[new Random().nextInt(length)];
        }
        return listResult;
    }
}