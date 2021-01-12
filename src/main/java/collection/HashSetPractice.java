package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetPractice {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashSetPractice.class);

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        // append some elements to the end of the set
        hashSet.add("One");
        hashSet.add("Two");
        hashSet.add("Three");
        hashSet.add("Four");
        hashSet.add("Five");
        LOGGER.info("{}",hashSet);
        // get an iterate and use it to print out all elements in the set
        hashSet.iterator().forEachRemaining(LOGGER::info);
        // print out the number of elements in the set
        LOGGER.info("size = {}", hashSet.size());
        // convert the set to a string array
        String[] arrayRes = hashSet.toArray(new String[0]);
        for(String s: arrayRes){
            LOGGER.info("{}", s);
        }
        // convert the set to a List/ArrayList
        List<String> list = new ArrayList<>(hashSet);

        Set<String> newHashSet = new HashSet<>(hashSet);
        // compare if two sets are equal
        newHashSet.equals(hashSet);

        newHashSet.add("Seven");
        newHashSet.add("Eight");
        newHashSet.add("Nine");
        newHashSet.remove("One");
        newHashSet.remove("Three");
        newHashSet.remove("Five");
        // compare two sets and retain elements which are same on both sets
        hashSet.retainAll(newHashSet);
        LOGGER.info("{}", hashSet);
        // remove all of the elements from the first set, check empty before and after
        hashSet.clear();
        hashSet.isEmpty();
    }
}
