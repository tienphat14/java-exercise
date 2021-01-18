package streamapi;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {

    private final String firstName;
    private final String surname;
    private final LocalDate dateOfBirth;
    private final Company company;
    private final BigDecimal salary;
    private final Address homeAddress;

    public Employee(String firstName, String surname, LocalDate dateOfBirth, Company company, BigDecimal salary, Address homeAddress) {
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.company = company;
        this.salary = salary;
        this.homeAddress = homeAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Company getCompany() {
        return company;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }
}
