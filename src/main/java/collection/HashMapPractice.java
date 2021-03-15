package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapPractice {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashMapPractice.class);

    public static void main(String[] args) {
        Map<Integer, String> hashMap = new LinkedHashMap<>();
        // TODO: put some mapping to the map

        hashMap.put(1, "One");
        hashMap.put(2, "One");
        hashMap.put(3, "Two");
        hashMap.put(4, "Three");
        hashMap.put(5, "Four");
        hashMap.put(6, "Five");


        // TODO: print out all keys in the map

        for (Integer i : hashMap.keySet()) {
            LOGGER.info("{}", i);
        }

        // TODO: print out all values in the map

        for (String s : hashMap.values()) {
            LOGGER.info("{}", s);
        }

        // TODO: print out all key-value pair in the map

        LOGGER.info("{}",hashMap);

        // TODO: print out the number of key-value in the map

        LOGGER.info("size = {}", hashMap.size());

        // TODO: check if the map contains key 5(true), 9(false)

        LOGGER.info("is contain key 5: {}", hashMap.containsKey(5));

        LOGGER.info("is contain key 9: {}", hashMap.containsKey(9));

        // TODO: check if the map contains value Five(true), Nine(false)

        

        // TODO: print out the value with key=6



        // TODO: remove all of the mappings from the map, check empty before and after
    }
}
