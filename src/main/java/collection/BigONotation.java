package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigONotation {

    private static final Logger LOGGER = LoggerFactory.getLogger(BigONotation.class);

    public static void main(String[] args) {
        new BigONotation().run();
    }

    public void run() {
        long hundredThousand = 100_000;
        long billion = 1_000_000_000L;
        long trillion = 1_000_000_000_000L;

        long start = System.currentTimeMillis();
        for (long i = 0L; i < hundredThousand; i++) {
            doSomething();
        }
        LOGGER.info("For loop O(n) with n = hundredThousand finished after {}ms", System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (long i = 0L; i < billion; i++) {
            doSomething();
        }
        LOGGER.info("For loop O(n) with n = billion finished after {}ms", System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (long i = 1L; i < hundredThousand; i *= 2) {
            doSomething();
        }
        LOGGER.info("For loop O(log(n)) with n = hundredThousand finished after {}ms", System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (long i = 1L; i < billion; i *= 2) {
            doSomething();
        }
        LOGGER.info("For loop O(log(n)) with n = billion finished after {}ms", System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (long i = 1L; i < trillion; i *= 2) {
            doSomething();
        }
        LOGGER.info("For loop O(log(n)) with n = trillion finished after {}ms", System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (long i = 0L; i < hundredThousand; i++) {
            for (long j = 0L; j < hundredThousand; j++) {
                doSomething();
            }
        }
        LOGGER.info("For loop log(n^2) with n = hundredThousand finished after {}ms", System.currentTimeMillis() - start);
    }

    public void doSomething() {
        int a = 1;
        int b = 2;
        int sum = a + b;
    }
}
