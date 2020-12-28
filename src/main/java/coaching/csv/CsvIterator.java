package coaching.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class CsvIterator implements Iterator<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CsvIterator.class);
    private Scanner scanner;

    public CsvIterator(File file) {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNextLine();
    }

    @Override
    public String next() {
        return scanner.nextLine();
    }

    public void close() {
        if (this.scanner != null) {
            this.scanner.close();
        }
    }
}
