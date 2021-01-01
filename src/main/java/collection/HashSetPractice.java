package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashSetPractice {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashSetPractice.class);

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("One");
        hashSet.add("Two");
        hashSet.add("Three");
        hashSet.add("Four");
        hashSet.add("Five");
        hashSet.add("Six");

        Iterator<String> iterator = hashSet.iterator();
        LOGGER.info("Set listing:");
        iterator.forEachRemaining(LOGGER::info);

        LOGGER.info("Size = {}", hashSet.size());

        String[] stringArray = hashSet.toArray(new String[0]);
        LOGGER.info("Array listing:");
        for (String s: stringArray) {
            LOGGER.info("{}", s);
        }

        List<String> stringList = new ArrayList<>(hashSet);
        LOGGER.info("List listing:");
        stringList.forEach(LOGGER::info);

        Set<String> newHashSet = new HashSet<>(hashSet);
        LOGGER.info("Two sets are equal: {}", hashSet.equals(newHashSet));

        newHashSet.add("Seven");
        newHashSet.add("Eight");
        newHashSet.add("Nine");
        newHashSet.remove("One");
        newHashSet.remove("Three");
        newHashSet.remove("Five");
        hashSet.retainAll(newHashSet);
        LOGGER.info("Elements are on both sets: {}", hashSet);

        LOGGER.info("First set is empty before: {}", hashSet.isEmpty());
        hashSet.clear();
        LOGGER.info("First set is empty after: {}", hashSet.isEmpty());
    }
}
