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
    public String[] getRandomRoster (String[] availableNames, int size) throws CustomException {
        if (availableNames.length <=0 || size <= 0) {
           throw new CustomException("Invalid input. Empty list or size is less than zero is not allowed.");
        }
        String[] results = new String[size];
        for (int i=0; i<size; i++){
            int ran = new Random().nextInt(availableNames.length);
            results[i] = availableNames[ran];
        }
        return results;
        //throw new UnsupportedOperationException("This method is not implemented yet");
    }

    public static void main(String[] args) {

       RandomRosterGenerator randomRoster = new RandomRosterGenerator();
       String[] test = {};
       String[] result;
       try {
           result = randomRoster.getRandomRoster(test, 4);
           for (String s: result){
               System.out.println(s);
           }
       }catch(CustomException err){
           System.out.println(err);
       }
    }
}

