package streamapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

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
        return EMPLOYEES.stream()
                .filter(e1 -> EMPLOYEES.stream()
                        .anyMatch(e2 -> e2 != e1 &&
                                e1.getFirstName().equals(e2.getFirstName()) &&
                                e1.getSurname().equals(e2.getSurname())))
                .findFirst()
                .map(e -> e.getFirstName() + " " + e.getSurname())
                .orElse("Not Found");
    }

    public long exercise2() {
        return EMPLOYEES.stream()
                .collect(
                        Collectors.groupingBy(
                                e -> e.getHomeAddress().getPostCode().substring(0, 2),
                                Collectors.counting()
                        ))
                .values()
                .stream()
                .filter(n -> n >= 5)
                .count();
    }

    public List<String> exercise3() {
        DecimalFormat decimalFormat = new DecimalFormat("£#,###.00");
        return EMPLOYEES.stream()
                .collect(
                        Collectors.groupingBy(
                                e -> e.getCompany().getName(),
                                Collectors.summingDouble(e -> e.getSalary().doubleValue())
                        ))
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + " - " + decimalFormat.format(entry.getValue()))
                .collect(Collectors.toList());
    }
}
