package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListPractice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayListPractice.class);

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("one", "two", "books", "three", "cats", "java", "dogs", "Dai", "Hung");
        LOGGER.info("All words: {}", stringList);
        LOGGER.info("All words in reverse order: {}", reverseList(stringList));
        LOGGER.info("Not effect All words: {}", stringList);
//        LOGGER.info("All words after capitalizing all plural: {}", capitalizePlurals(stringList));
//        LOGGER.info("All words after removing all plural: {}", removePlurals(stringList));
//        LOGGER.info("All words after adding star after each word: {}", addStars(stringList));
//        LOGGER.info("All words after removing stars: {}", removeStars(stringList));
    }

    public static List<String> reverseList(List<String> list) {
        List<String> result = new ArrayList<>(list);
        Collections.reverse(result);
        return result;
    }

    public static List<String> capitalizePlurals(List<String> list) {
        // TODO: capitalize all plurals (ending in 's')
        throw new UnsupportedOperationException();
    }

    public static List<String> removePlurals(List<String> list) {
        // TODO: remove all plural (ending in 's')
        throw new UnsupportedOperationException();
    }

    public static List<String> addStars(List<String> list) {
        // TODO: add star after each word - "one", "*", "two", "*", "books", "*",...
        throw new UnsupportedOperationException();
    }

    public static List<String> removeStars(List<String> list) {
        // TODO: remove stars which added by addStars
        throw new UnsupportedOperationException();
    }
}
