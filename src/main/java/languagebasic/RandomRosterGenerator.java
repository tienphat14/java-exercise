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
        //throw new UnsupportedOperationException("This method is not implemented yet");
        int i;
        if (availableNames.length != 0 && size > 0) {
            String [] rosterRandomNames = new String[size];
            for(i = 0; i < size; i++) {
                rosterRandomNames[i] = availableNames[(int) (Math.random() * (availableNames.length - 1))];
            }
            return rosterRandomNames;
        }
        return new String[0];
    }
}