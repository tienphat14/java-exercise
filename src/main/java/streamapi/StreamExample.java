package streamapi;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamExample.class);

    public static void main(String args[]) {

        List<String> wordList = Arrays.asList("one", "Reflection", "two", "Collection", "three", "Stream");

        LOGGER.info("Original list: {}", wordList);

        LOGGER.info("Filtered list: {}",
                wordList.stream()
                        .filter(s -> s.startsWith("S"))
                        .collect(Collectors.toList()));

        LOGGER.info("Transform to capitalized list: {}",
                wordList.stream()
                        .map(StringUtils::capitalize)
                        .collect(Collectors.toSet()));

        LOGGER.info("Sorted list: {}",
                wordList.stream()
                        .sorted()
                        .collect(Collectors.toList()));
        LOGGER.info("************************************************************");
        List<Integer> numberList = Arrays.asList(2,3,4,5,2);

        LOGGER.info("All number:");
        numberList.stream().forEach(n -> LOGGER.info("{}", n));

        LOGGER.info("Sum all: {}", numberList.stream().reduce(0, Integer::sum));
    }
}
