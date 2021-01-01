package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListPractice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayListPractice.class);

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("one", "two", "books", "three", "cats", "java", "dogs", "Dai", "Hung");
        LOGGER.info("All words: {}", stringList);
        LOGGER.info("All words in reverse order: {}", reverseList(stringList));
        LOGGER.info("All words after capitalizing all plural: {}", capitalizePlurals(stringList));
        LOGGER.info("All words after removing all plural: {}", removePlurals(stringList));
        LOGGER.info("All words after adding star after each word: {}", addStars(stringList));
        LOGGER.info("All words after removing stars: {}", removeStars(stringList));
    }

    public static List<String> reverseList(List<String> list) {
        List<String> result = new ArrayList<>(list);
        Collections.reverse(result);
        return result;
    }

    public static List<String> capitalizePlurals(List<String> list) {
        List<String> result = new ArrayList<>(list);
        for (int i = 0; i < result.size(); i++) {
            String s = result.get(i);
            if (s.endsWith("s")) {
                result.set(i, s.substring(0, 1).toUpperCase() + s.substring(1));
            }
        }
        return result;
    }

    public static List<String> removePlurals(List<String> list) {
        return list.stream().filter(s -> !s.endsWith("s")).collect(Collectors.toList());
    }

    public static List<String> addStars(List<String> list) {
        List<String> result = new ArrayList<>(list);
        for (int i = 1; i <= result.size(); i += 2) {
            result.add(i, "*");
        }
        return result;
    }

    public static List<String> removeStars(List<String> list) {
        return list.stream().filter(s -> !"*".equals(s)).collect(Collectors.toList());
    }
}
