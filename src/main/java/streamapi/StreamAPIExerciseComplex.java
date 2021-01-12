package streamapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.List;

public class StreamAPIExerciseComplex {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamAPIExerciseComplex.class);
    private static final List<Employee> EMPLOYEES = Employees.allEmployees();

    public static void main(String[] args) {
        StreamAPIExerciseComplex excercise = new StreamAPIExerciseComplex();
        LOGGER.info("{}", excercise.exercise1());
        LOGGER.info("{}", excercise.exercise2());
        LOGGER.info("{}", excercise.exercise3());
    }

    public String exercise1() {
        // TODO: find whether there are two employees with the same first name and surname and return the name
        throw new UnsupportedOperationException();
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
