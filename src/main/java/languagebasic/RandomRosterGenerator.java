package languagebasic;

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
        if (size <= 0) {
           return new String[]{};
        }
        String[] result = new String[size];
        if (size <= availableNames.length) {
            System.arraycopy(availableNames, 0, result, 0, size);
            return result;
        }
        else {
            return new String[]{};
        }
    }
}