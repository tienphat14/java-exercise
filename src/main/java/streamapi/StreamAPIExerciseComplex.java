package streamapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
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
                .filter(emp1 -> EMPLOYEES.stream()
                        .anyMatch(emp2 -> emp1 != emp2
                                && emp1.getFirstName().equals(emp2.getFirstName())
                                && emp1.getSurname().equals(emp2.getSurname())
                        )
                )
                .map(emp -> emp.getFirstName() + " " + emp.getSurname())
                .findFirst()
                .orElse("Not Found");
    }

    public long exercise2() {
        return EMPLOYEES.stream()
                .map(emp -> emp.getHomeAddress().getPostCode().substring(0, 2))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .filter(n -> n >= 5)
                .count();
    }

    public List<String> exercise3() {
        DecimalFormat decimalFormat = new DecimalFormat("£#,###.00");
        return EMPLOYEES.stream()
                .collect(Collectors.groupingBy(emp -> emp.getCompany().getName(),
                        Collectors.reducing(BigDecimal.ZERO, Employee::getSalary, BigDecimal::add)))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(e -> e.getKey() + ": " + decimalFormat.format(e.getValue()))
                .collect(Collectors.toList());
    }
}
