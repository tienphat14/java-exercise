package coaching.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Iterator for a csv file
 */
public class CsvIterator implements Iterator<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CsvIterator.class);
    private Scanner scanner;

    /**
     * Initialize a csv iterator
     * @param file
     */
    public CsvIterator(File file) {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check the existence of a next line
     * @return true if having a next line
     */
    @Override
    public boolean hasNext() {
        return scanner.hasNextLine();
    }

    /**
     * Get the next line
     * @return a string of the next line
     */
    @Override
    public String next() {
        return scanner.nextLine();
    }

    /**
     * Close the scanner of csv file
     */
    public void close() {
        if (this.scanner != null) {
            this.scanner.close();
        }
    }
}
