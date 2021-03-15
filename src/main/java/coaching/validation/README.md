# MODULE 2 - Validation

## Exercise Format
Exercise is designed to follow Test-Driven Development principles, which means your implementation
must pass all unit tests as definition of done. We have defined set of classes and methods that
you need to implement.

## Required Knowledge
- Java Basic (conditional statement, loop, string manipulate...) 
- Java Reflection API
- Java Annotation

## Requirements
- Implement validation engine that utilizes field-level annotation to run rules against declared 
  fields. After validation, violation set is returned that contains which field violates which rules.
- The engine should be extensible which means that you could add your custom validation rule with
  very little effort. For this one, please propose your approach, implement it and then write unit
  tests to validate this aspect.
- Code documentation is required (apply to public method and class), it should clarify the
  purpose and usage.
- Implementation must align to coding conventions which is readable, maintainable, extensible.
- All unit tests must be passed, which determine your result.

### Expected API Usage
Code sample of validation API usage
```java
class coaching.App {
    public static void main(String ...args) {     
        // Initialize validator
        final Validator validator = new DefaultValidator();

        // Validated data
        final Staff staff = new Staff();
        staff.setFirstName(null);
        staff.setLasName("SD23");

        // Validate and return violation. One violation is only responsible for
        // one field violation. If that field violates multiple constraints, it should
        // have multiple error messages. Please inspect Violation model for details 
        final Set<Violation> violations = validator.validate(staff);
    }

    // Validated model
    public static class Staff {
        @NotNull(message = "First name must not be null")
        private String firstName;

        @Size(min = 1, max = 3, message = "Last name size must be between 1 and 3")
        @Regex(pattern = "[a-zA-Z]*", message = "Last name must be alphabetic characters only")
        private String lastName;
    
        // Getters and Setters here
    }
}
```