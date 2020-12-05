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
    public String[] getRandomRoster (String[] availableNames, int size) {
        if (availableNames.length <=0 || size <= 0) {
            return new String[0]; //return empty string if invalid input

        }
        String[] results = new String[size];
        for (int i=0; i<size; i++){
            int ran = new Random().nextInt(availableNames.length);
            results[i] = availableNames[ran];
        }
        return results;
    }

}

