# MODULE 1 - CSV Parser and CSV Writer

## Exercise Format
Exercise is designed to follow Test-Driven Development principles, which means your implementation
must pass all unit tests that is definition of done. We have defined set of classes and methods that
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
- Code documentation is required (apply to public method and class), it should clarify the
  purpose and usage.
- Implementation must align to coding conventions which is readable, maintainable, extensible.
- Reflection API is not allowed in this exercise.
- All unit tests must be passed, which determine your result.