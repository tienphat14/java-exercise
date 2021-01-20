package streamapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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
                        .anyMatch(e2 -> e1 != e2 && e1.getFirstName().equals(e2.getFirstName()) && e1.getSurname().equals(e2.getSurname())))
                .map(e -> e.getFirstName() + " " + e.getSurname())
                .findFirst()
                .orElse("Not Found");
    }

    public long exercise2() {
        // find the total number of groups of at least 5 employees living close to each other
        // consider all employees with the same 2 first characters of the home address post code a single groupList<String> strings = List.of("a", "bb", "cc", "ddd");
        return EMPLOYEES.stream()
                        .map(e1-> e1.getHomeAddress())
                        .map(p -> p.getPostCode().substring(0, 2))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .values()
                        .stream()
                        .filter(l -> l >= 5)
                        .count();
    }

    public List<String> exercise3() {
        DecimalFormat decimalFormat = new DecimalFormat("£#,###.00");
        // find how much in total each company pays to their employees, order result by amount
        // Barclays plc - £12,184,531.00

       return  EMPLOYEES.stream()
                .collect(Collectors.groupingBy(employee -> employee.getCompany().getName(), Collectors.reducing(BigDecimal.ZERO, Employee::getSalary, BigDecimal::add)))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(x -> x.getKey() + " - " + decimalFormat.format(x.getValue()))
                .collect(Collectors.toList());
    }
}
