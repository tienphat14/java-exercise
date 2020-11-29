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
        if (availableNames == null || availableNames.length == 0) {
            return new String[]{};
        }

        if (size <= 0) {
            return new String[]{};
        }

        String[] names = new String[size];
        int randomIndex = 0;
        for (int i = 0; i < size; i++) {
            randomIndex = new Random().nextInt(availableNames.length);
            names[i] = availableNames[randomIndex];
        }
        return names;
    }
}