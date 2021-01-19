package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class HashSetPractice {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashSetPractice.class);

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

        hashSet.add("One");
        hashSet.add("Three");
        hashSet.add("Ten");
        hashSet.add("Eleven");
        hashSet.add("Seven");
        hashSet.add("Four");
        hashSet.add("One");

        hashSet.iterator().forEachRemaining(LOGGER::info);

        LOGGER.info("-----------------------------------------");
        LOGGER.info("print out the number of elements in the set: {}", hashSet.size());

        LOGGER.info("-----------------------------------------");
        String[] strArr = hashSet.toArray(new String[0]);
        for (String s: strArr){
            LOGGER.info("{}", s);
        }

        LOGGER.info("-----------------------------------------");
        List<String> list = new ArrayList<>(hashSet);
        LOGGER.info("{}", list);

        LOGGER.info("-----------------------------------------");
        Set<String> newHashSet = new HashSet<>(hashSet);
        LOGGER.info("compare if two sets are equal: {}", hashSet.equals(newHashSet));

        LOGGER.info("-----------------------------------------");
        newHashSet.add("Seven");
        newHashSet.add("Eight");
        newHashSet.add("Nine");
        newHashSet.remove("One");
        newHashSet.remove("Three");
        newHashSet.remove("Five");

        LOGGER.info("-----------------------------------------");
        hashSet.retainAll(newHashSet);
        LOGGER.info("compare two sets and retain elements which are same on both sets:{}", hashSet);

        LOGGER.info("-----------------------------------------");
        hashSet.clear();
        LOGGER.info("remove all of the elements from the first set, check empty before and after:{}", hashSet.isEmpty());

    }
}
