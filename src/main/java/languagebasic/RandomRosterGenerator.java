package languagebasic;

import java.util.Random;

/**
 * Generate a random roster to review assignments =]]
 */
public class RandomRosterGenerator {
    public static final Integer DEFAULT_LENGTH_ARRAY = 0;

    /**
     * Get a roster from an array of available names. Duplication is allowed
     *
     * @param availableNames Array of available names
     * @param size           Size of the roster you want to get
     * @return A roster with the desired size or empty if invalid input
     */
    public String[] getRandomRoster(String[] availableNames, int size) {
        String[] temp = new String[DEFAULT_LENGTH_ARRAY];
        if (availableNames.length != 0 && size > 0) {
            temp = new String[size];
            for (int i = 0; i < size; i++) {
                int rnd = new Random().nextInt(availableNames.length);
                temp[i] = availableNames[rnd];
            }
        }
        return temp;
    }
}