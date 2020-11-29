# MODULE 1 - CSV Parser and CSV Writer

## Exercise Format
Exercise is designed to follow Test-Driven Development principles, which means your implementation
must pass all unit tests as definition of done. We have defined set of classes and methods that
you need to implement.

## Required Knowledge
- Java Basic (conditional statement, loop, string manipulate...) 
- Java IO
- Java Collection

## Requirements
- Implement CSV parser that could iterate CSV file line by line (for memory optimization). 
  The parser should be customizable. For example, the parser could handle different set of
  delimiter character such as comma, pipeline, ... It could also handle data wrapped by 
  double quotes.
- Implement CSV writer that could flush all data into a file in CSV format. The writer is
  expected to be customizable with a custom delimiter, whether data should be wrapped with
  double quotes.
- Exceptions should be handled correctly
- Code documentation is required (apply to public method and class), it should clarify the
  purpose and usage.
- Implementation must align to coding conventions which is readable, maintainable, extensible.
- All unit tests must be passed, which determine your result.

### Expected API Usage
Code sample of CsvParser API usage
```java
class App {
    public static void main(String ...args) {                                             
        // Initialize parser
        final File file = new File("foo.csv");
        final CsvParser parser = new DefaultCsvParser(file);
        
        // Iterate through each lines
        while (parser.hasNext()) {
            final CsvLine line = parser.next();
            // Print value of the first segment
            System.out.println(line.get(0));
        }

        // Close resource after reading a file
        parser.close();
    }
}
```

Code sample of CsvWriter API usage
```java
class App {
    public static void main(String ...args) {
        // Initialize writer
        final File file = new File("foo.csv");
        final CsvWriter writer = new DefaultCsvWriter();

        // Set value for the first segment
        final CsvLine line = new CsvLine();
        line.set(0, "bar");

        // Write data into a file
        writer.write(line);

        // Close resources
        writer.close();
    }
}
```