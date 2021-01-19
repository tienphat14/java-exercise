package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class HashMapPractice {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashMapPractice.class);

    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "MU");
        hashMap.put(2, "Real Madrid");
        hashMap.put(3, "MC");
        hashMap.put(5, "PSV");
        hashMap.put(6, "Five");


        LOGGER.info("print out all keys in the map: {}", hashMap.keySet());


        LOGGER.info("print out all values in the map: {}", hashMap.values());


        LOGGER.info("print out all key-value pair in the map: {}", hashMap.entrySet());


        LOGGER.info("print out the number of key-value in the map: {}", hashMap.size());


        LOGGER.info("check if the map contains key 5: {}, 9: {}", hashMap.containsKey(5), hashMap.containsKey(9));


        LOGGER.info("check if the map contains value Five: {}, Nine: {}", hashMap.containsValue("Five"), hashMap.containsValue("Nine"));


        LOGGER.info("print out the value with key=6 : {}", hashMap.get(6));

        hashMap.clear();
        LOGGER.info("remove all of the mappings from the map, check empty before and after: {}", hashMap.isEmpty());
    }
}
