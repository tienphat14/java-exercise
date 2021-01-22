package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class HashMapPractice {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashMapPractice.class);

    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        hashMap.put(4, "Four");
        hashMap.put(5, "Five");
        hashMap.put(6, "Six");

        for (Integer i : hashMap.keySet()) {
            LOGGER.info("Key: {}", i);
        }

        for (String value : hashMap.values()) {
            LOGGER.info("Value: {}", value);
        }

        for (Map.Entry entry : hashMap.entrySet()) {
            LOGGER.info("Key: {} - Value: {}", entry.getKey(), entry.getValue());
        }

        LOGGER.info("The size of map: {}", hashMap.size());

        LOGGER.info("The map contains key 5: {}", hashMap.containsKey(5));
        LOGGER.info("The map contains key 9: {}", hashMap.containsKey(9));

        LOGGER.info("The map contains value Five: {}", hashMap.containsValue("Five"));
        LOGGER.info("The map contains value Nine: {}", hashMap.containsValue("Nine"));

        LOGGER.info("The value with key = 6: {}", hashMap.get(6));

        if (!hashMap.isEmpty()) {
            hashMap.clear();
        }
        LOGGER.info("The map is empty: {}", hashMap.isEmpty());
    }
}