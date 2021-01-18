package collection;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ArrayListPractice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayListPractice.class);

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("one", "two", "books", "three", "cats", "java", "dogs", "Dai", "Hung");
        LOGGER.info("All words: {}", stringList);
        LOGGER.info("All words in reverse order: {}", reverseList(stringList));
        LOGGER.info("All words after capitalizing all plural: {}", capitalizePlurals(stringList));
        LOGGER.info("All words after removing all plural: {}", removePlurals(stringList));
        LOGGER.info("All words after adding star after each word: {}", addStars(stringList));
//        LOGGER.info("All words after removing stars: {}", removeStars(stringList));
    }

    public static List<String> reverseList(List<String> list) {
        Collections.reverse(list);
        return list;
    }

    public static List<String> capitalizePlurals(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).endsWith("s")) {
                list.set(i,StringUtils.capitalize(list.get(i)));
            }
        }
        return list;
    }

    public static List<String> removePlurals(List<String> list) {
        List<String> singularList = new ArrayList<>();
        for (String s: list) {
            if (!s.endsWith("s")) {
                singularList.add(s);
            }
        }
        return singularList;
    }

    public static List<String> addStars(List<String> list) {
        List<String> starList = new ArrayList<>(list);
        for (int i = 1; i < starList.size(); i += 2) {
            list.add(i,"*");
        }
        return starList;
    }

    public static List<String> removeStars(List<String> list) {
        // TODO: remove stars which added by addStars
        throw new UnsupportedOperationException();
    }
}
