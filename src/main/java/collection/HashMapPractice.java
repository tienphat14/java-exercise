package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class HashMapPractice {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashMapPractice.class);

    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        // put some mapping to the map
        hashMap.put(1 ,"One");
        hashMap.put(1 ,"One");
        hashMap.put(1 ,"One");
        hashMap.put(1 ,"One");
        hashMap.put(1 ,"One");


        // TODO: print out all keys in the map

        // TODO: print out all values in the map

        // TODO: print out all key-value pair in the map

        // TODO: print out the number of key-value in the map

        // TODO: check if the map contains key 5(true), 9(false)

        // TODO: check if the map contains value Five(true), Nine(false)

        // TODO: print out the value with key=6

        // TODO: remove all of the mappings from the map, check empty before and after
    }
}
