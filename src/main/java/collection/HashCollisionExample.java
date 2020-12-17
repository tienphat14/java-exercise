package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCollisionExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashCollisionExample.class);

    public static void main(String[] args) {
        new HashCollisionExample().action();
    }

    private void action() {
        Map<MapKey, Integer> hashMap = new HashMap<>();

        hashMap.put(new MapKey("vishal"), 20);
        hashMap.put(new MapKey("sachin"), 30);
        hashMap.put(new MapKey("vaibhav"), 40);

        hashMap.keySet().forEach(k -> LOGGER.info(k.key));
    }

    class MapKey {
        String key;
        MapKey(String key) {
            this.key = key;
        }

        @Override
        public int hashCode() {
            int hash = (int)key.charAt(0);
            LOGGER.info("hashCode for key {} = {}", key, hash);
            return hash;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MapKey)) return false;
            MapKey mapKey = (MapKey) o;
            return Objects.equals(key, mapKey.key);
        }
    }
}
