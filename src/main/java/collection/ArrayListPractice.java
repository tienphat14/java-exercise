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
        LOGGER.info("All words after capitalizing all plural: {}", capitalizePlurals(stringList));
        LOGGER.info("All words after removing all plural: {}", removePlurals(stringList));
        LOGGER.info("All words after adding star after each word: {}", addStars(stringList));
        LOGGER.info("All words after removing stars: {}", removeStars(stringList));
    }

    public static List<String> reverseList(List<String> list) {
        Collections.reverse(list);
        return list;
    }

    public static List<String> capitalizePlurals(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.endsWith("s")) {
                list.set(i, s.substring(0, 1).toUpperCase().concat(s.substring(1)));
            }
        }
        return list;
    }

    public static List<String> removePlurals(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            if (!s.endsWith("s")) {
                newList.add(s);
            }
        }
        return newList;
    }

    public static List<String> addStars(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            newList.add(list.get(i));
            if (!list.get(i).equals("*")) {
                newList.add("*");
            }
        }
        return newList;
    }

    public static List<String> removeStars(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals("*")) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }
}
