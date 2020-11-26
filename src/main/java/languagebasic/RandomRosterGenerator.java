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
        //TODO: implement this method
        if (availableNames.length == 0 || size < 1)
            return new String[0];
        String[] rst = new String[size];
        int count = -1;
        int maxAvailableIdx = availableNames.length;
        while (++count < size) {
            rst[count] = availableNames[(int) (Math.random() * (maxAvailableIdx - 1))];
        }
        return rst;
    }
}