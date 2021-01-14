package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class HashSetPractice {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashSetPractice.class);

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        // TODO: append some elements to the end of the set

        // TODO: get an iterate and use it to print out all elements in the set

        // TODO: print out the number of elements in the set

        // TODO: convert the set to a string array

        // TODO: convert the set to a List/ArrayList

        Set<String> newHashSet = new HashSet<>(hashSet);
        // TODO: compare if two sets are equal

        newHashSet.add("Seven");
        newHashSet.add("Eight");
        newHashSet.add("Nine");
        newHashSet.remove("One");
        newHashSet.remove("Three");
        newHashSet.remove("Five");
        // TODO: compare two sets and retain elements which are same on both sets

        // TODO: remove all of the elements from the first set, check empty before and after
    }
}
