package streamapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.List;

public class StreamAPIExerciseComplex {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamAPIExerciseComplex.class);
    private static final List<Employee> EMPLOYEES = Employees.allEmployees();

    public static void main(String[] args) {
        StreamAPIExerciseComplex exercise = new StreamAPIExerciseComplex();
        LOGGER.info("{}", exercise.exercise1());
        LOGGER.info("{}", exercise.exercise2());
        LOGGER.info("{}", exercise.exercise3());
    }

    /**
     * Find whether there are two employees with the same first name and surname and return the name
     * @return the first name
     */
    public String exercise1() {
        return EMPLOYEES.stream().filter( e -> EMPLOYEES
            .stream()
            .anyMatch(e2 -> StreamAPIExerciseComplex.compare(e, e2)))
                .map(e-> e.getFirstName() + " " + e.getSurname())
                .findFirst()
                .orElse("Not Found");
    }

    public static  boolean compare(Employee e1, Employee e2){
        return e1 != e2 && e1.getFirstName().equals(e2.getFirstName()) && e1.getSurname().equals(e2.getSurname());
    }


    public long exercise2() {
        // TODO: find the total number of groups of at least 5 employees living close to each other
        // consider all employees with the same 2 first characters of the home address post code a single group
        throw new UnsupportedOperationException();
    }

    public List<String> exercise3() {
        DecimalFormat decimalFormat = new DecimalFormat("£#,###.00");
        // TODO: find how much in total each company pays to their employees, order result by amount
        // Barclays plc - £12,184,531.00
        throw new UnsupportedOperationException();
    }
}