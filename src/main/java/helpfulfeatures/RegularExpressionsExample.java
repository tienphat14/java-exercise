package helpfulfeatures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegularExpressionsExample.class);

    public static void main(String[] args) {
        new RegularExpressionsExample().example1();
        new RegularExpressionsExample().example2();
        new RegularExpressionsExample().example3();
    }

    private void example1() {
        String s = "Hello there , to day is a great day . Let work hard together !";
        String pattern = "(\\w)(\\s+)([.,])";
        LOGGER.info("Original string:");
        LOGGER.info("{}", s);
        s = s.replaceAll(pattern, "$1$3");
        LOGGER.info("After removing whitespace between a word character and . or ,:");
        LOGGER.info("{}", s);
        LOGGER.info("****************************************");
    }

    private void example2() {
        String s = "Hello world from Regular Expressions Example!!!";

        LOGGER.info("Example string:");
        LOGGER.info("{}", s);
        LOGGER.info("Contains only word character: {}", s.matches("\\w+"));
        String[] splitString = (s.split("\\s+"));
        LOGGER.info("Has {} words:", splitString.length);
        for (String string : splitString) {
            LOGGER.info(string);
        }
        s = s.replaceAll("\\s+", "\t");
        LOGGER.info("After replacing all whitespace with tabs:");
        LOGGER.info("{}", s);
        LOGGER.info("****************************************");
    }

    private void example3() {
        String s = "Example string for pattern matching.";
        LOGGER.info("Example string:");
        LOGGER.info("{}", s);
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            LOGGER.info("Start index: {} End index: {}", matcher.start(), matcher.end());
            LOGGER.info("{}", matcher.group());
        }
        Pattern replace = Pattern.compile("\\s+");
        Matcher matcher2 = replace.matcher(s);
        LOGGER.info("After replacing all whitespace with tabs:");
        LOGGER.info("{}", matcher2.replaceAll("\t"));
    }
}
