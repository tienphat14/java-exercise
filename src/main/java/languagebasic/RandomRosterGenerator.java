package languagebasic;

import java.util.ArrayList;
import java.util.Arrays;
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
        ArrayList<String> newArrayNames = new ArrayList<>();
        try{
            for(int i=0;i<size;i++){
                int randomNumber= new Random().nextInt(availableNames.length);
                newArrayNames.add(availableNames[randomNumber]);
            }
            System.out.println("DEBUG ONLY: " + newArrayNames);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught an IllegalArgumentException..." + e.getMessage());
        }
        return newArrayNames.toArray(new String[0]);
    }
}