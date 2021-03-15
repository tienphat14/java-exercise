package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class HashSetPractice {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashSetPractice.class);

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

        // TODO: append some elements to the end of the set
        hashSet.add("One");
        hashSet.add("One");
        hashSet.add("Two");
        hashSet.add("Three");
        hashSet.add("Four");
        hashSet.add("Five");
        // TODO: get an iterate and use it to print out all elements in the set

        hashSet.iterator().forEachRemaining(LOGGER::info);

        // TODO: print out the number of elements in the set

        LOGGER.info("{}", hashSet.size());

        // TODO: convert the set to a string array

        Arrays.stream(hashSet.toArray(new String[0])).forEach(LOGGER::info);

        // TODO: convert the set to a List/ArrayList

        new ArrayList<>(hashSet).forEach(LOGGER::info);

        Set<String> newHashSet = new HashSet<>(hashSet);
        // TODO: compare if two sets are equal

        newHashSet.add("Seven");
        newHashSet.add("Eight");
        newHashSet.add("Nine");
        newHashSet.remove("One");
        newHashSet.remove("Three");
        newHashSet.remove("Five");
        // TODO: compare two sets and retain elements which are same on both sets

        Set<String> sameElements = new HashSet<>();

        for (String s : hashSet) {
            if (newHashSet.contains(s)) {
                sameElements.add(s);
            }
        }

        LOGGER.info("{}", sameElements);

        // TODO: remove all of the elements from the first set, check empty before and after

        hashSet.clear();
    }
}
