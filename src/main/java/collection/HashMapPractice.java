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

        LOGGER.info("{}", hashMap.keySet());

        LOGGER.info("{}", hashMap.values());

        LOGGER.info("{}", hashMap.entrySet());

        LOGGER.info("Size = {}", hashMap.size());

        LOGGER.info("Map contains key = {}: {}", 5, hashMap.containsKey(5));
        LOGGER.info("Map contains key = {}: {}", 9, hashMap.containsKey(9));

        LOGGER.info("Map contains value = {}: {}", "Five", hashMap.containsValue("Five"));
        LOGGER.info("Map contains value = {}: {}", "Nine", hashMap.containsValue("Nine"));

        LOGGER.info("Key = {} has value = {}", 6, hashMap.get(6));

        LOGGER.info("Map is empty before: {}", hashMap.isEmpty());
        hashMap.clear();
        LOGGER.info("Map is empty after: {}", hashMap.isEmpty());
    }
}
