package languagebasic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Generate a random roster to review assignments =]]
 */
public class RandomRosterGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RandomRosterGenerator.class);

    /**
     * Get a roster from an array of available names. Duplication is allowed
     *
     * @param availableNames Array of available names
     * @param size Size of the roster you want to get
     * @return A roster with the desired size or empty if invalid input
     */
    public String[] getRandomRoster(String[] availableNames, int size) {
        try {
            String[] result = new String[size];
            Random random = new Random();

            for (int i = 0; i < size; i++) {
                result[i] = availableNames[random.nextInt(availableNames.length)];
            }

            return result;
        } catch (Exception e) {
            LOGGER.error("Could not getRandomRoster, return empty array", e);
            return new String[]{};
        }
    }
}