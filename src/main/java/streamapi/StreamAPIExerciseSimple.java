package streamapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class StreamAPIExerciseSimple {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamAPIExerciseSimple.class);

    public static void main(String[] args) {
        StreamAPIExerciseSimple exercise = new StreamAPIExerciseSimple();
        LOGGER.info("--(1) {}", exercise.exercise1());
        LOGGER.info("{}", exercise.exercise2());
        LOGGER.info("{}", exercise.exercise3());
        LOGGER.info("{}", exercise.exercise4());
    }

    /**
     * divide each number by 2 (ignoring the reminder) and collect to set
     * @return [0, 1, 2]
     */
    public Set<Integer> exercise1() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        return numbers.stream()
                .map( n -> n/2)
                .collect(Collectors.toSet());
    }

    /**
     * Find all distinct reminders of division by 13 and collect them sorted
     * @return [2, 3, 4, 5, 6, 9]
     */
    public List<Integer> exercise2() {
        List<String> strings = asList("9", "4", "5", "6", "2", "3", "9", "4", "3", "4", "5");
        return  strings.stream()
                .map(Integer::valueOf)
                .map(n -> n % 13)
                .sorted().distinct()
                .collect(Collectors.toList());
    }

    /**
     * Find the length of the longest string
      * @return 11
     */
    public int exercise3() {
        List<String> strings = asList("Lorem", "ipsum", "dolor", "sit", "amet,", "consectetur", "adipiscing", "elit.");
        return strings.stream()
                .max(Comparator.comparingInt(String::length))
                .get()
                .length();
    }

    /**
     * Find first 5 numbers divisible by 17 generate by an infinite stream
     * @return [938301587, 100082026, 356750287, 798819494, 1412716779]
     */
    public List<Integer> exercise4() {
        IntStream numbers = new Random(0).ints().map(Math::abs);
        return numbers.filter(n -> n % 17 == 0)
                .limit(5)
                .boxed()
                .collect(Collectors.toList());
    }
}
