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
        StreamAPIExerciseSimple excercise = new StreamAPIExerciseSimple();
        LOGGER.info("{}", excercise.exercise1());
        LOGGER.info("{}", excercise.exercise2());
        LOGGER.info("{}", excercise.exercise3());
        LOGGER.info("{}", excercise.exercise4());
    }

    private Set<Integer> exercise1() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        return numbers.stream()
                .map(n -> n/2)
                .collect(Collectors.toSet());
    }

    private List<Integer> exercise2() {
        List<String> strings = asList("9", "4", "5", "6", "2", "3", "9", "4", "3", "4", "5");
        return strings.stream()
                .map(Integer::valueOf)
                .distinct()
                .map(n -> n % 13)
                .sorted()
                .collect(Collectors.toList());
    }

    private int exercise3() {
        List<String> strings = asList("Lorem", "ipsum", "dolor", "sit", "amet,", "consectetur", "adipiscing", "elit.");
        return strings.stream()
                .map(String::length)
                .max(Comparator.naturalOrder())
                .orElse(-1);
    }

    private List<Integer> exercise4() {
        IntStream numbers = new Random(0).ints().map(Math::abs);
        return numbers.filter(n -> n % 17 == 0)
                .limit(5)
                .boxed()
                .collect(Collectors.toList());
    }
}
