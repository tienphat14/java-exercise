package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class HashSetPractice {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashSetPractice.class);

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

        hashSet.add("one");
        hashSet.add("two");
        hashSet.add("three");
        hashSet.add("four");

        LOGGER.info("Hashset: {}", hashSet);
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            LOGGER.info("Iterator: {}", iterator.next());
        }

        LOGGER.info("The number of elements in the set: {}", hashSet.size());

        String[] str = hashSet.toArray(new String[0]);
        Arrays.stream(str).forEach(s -> LOGGER.info(s));

        // TODO: convert the set to a List/ArrayList and vice versa
        List<String> listFromHashSet = new ArrayList<>(hashSet);
        HashSet<String> hashSetFromList = new HashSet<>(listFromHashSet);

        Set<String> newHashSet = new HashSet<>(hashSet);

        newHashSet.add("Seven");
        newHashSet.add("Eight");
        newHashSet.add("Nine");
        newHashSet.remove("One");
        newHashSet.remove("Three");
        newHashSet.remove("Five");
        LOGGER.info("Compare 2 hash sets: {}", newHashSet.equals(hashSet));

        newHashSet.retainAll(hashSet);
        LOGGER.info("New hashSet after retaining the same elements: {}", newHashSet);

        hashSet.clear();
        LOGGER.info("HashSet is cleared: {}", hashSet.isEmpty());
    }
}
