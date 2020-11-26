# MODULE 3 - Repository

## Exercise Format
Exercise is designed to follow Test-Driven Development principles, which means your implementation
must pass all unit tests as definition of done. We have defined set of classes and methods that
you need to implement.

## Required Knowledge
- Java Basic (conditional statement, loop, string manipulate...) 
- Java IO
- Java Collection
- Java Data Source API
- Database Resources Management
- Basic SQL

## Requirements
- Implement repository that utilizes Java DataSource API. Here are suggested data source implementation:
  - [Hikari Datasource](https://github.com/brettwooldridge/HikariCP)
  - [Common DBCP](https://commons.apache.org/proper/commons-dbcp/index.html)
- Utilize resources relating to database correctly.
- Exceptions should be handled correctly
- Code documentation is required (apply to public method and class), it should clarify the
  purpose and usage.
- Implementation must align to coding conventions which is readable, maintainable, extensible.
- All unit tests must be passed, which determine your result.

### Expected API Usage
Code sample of repository API usage
```java
class App {
    public static void main(String ...args) {     
        // Initialize repository
        final DataSource dataSource; // Declare your datasource
        final CrudRepository<Staff> repository = new StaffRepository(dataSource);
                                        
        // Save a new staff into data persistence
        final Staff staff = new Staff();
        repository.save(Collections.singletonList(staff));

        // Retrieve all staffs
        final Collection<Staff> staffs = repository.findAll();
    }
}
```