package helpfulfeatures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FunctionalInterfaceExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(LambdaExample.class);

    public static void main(String[] args) {
        Map<String, Integer> nameMap = new HashMap<>();
        LOGGER.info("John has length = {}", nameMap.computeIfAbsent("John", s -> s.length()));
        LOGGER.info("************************************************************");

        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);
        salaries.replaceAll((name, oldValue) -> name.equals("Freddy") ? oldValue : oldValue + 10000);
        LOGGER.info("{}", salaries);
        LOGGER.info("************************************************************");

        Supplier<Double> randomValue = () -> Math.random();
        LOGGER.info("A random number: {}", randomValue.get());
        LOGGER.info("************************************************************");

        List<String> names = Arrays.asList("John", "Freddy", "Samuel");
        names.forEach(name -> LOGGER.info("Hello {}", name));
        LOGGER.info("************************************************************");

        List<String> namesWithS = names.stream()
                .filter(name -> name.startsWith("S"))
                .collect(Collectors.toList());
        LOGGER.info("Name start with 'S': {}", namesWithS);
        LOGGER.info("************************************************************");

        FunctionalInterfaceExample example = new FunctionalInterfaceExample();
        Function<Integer, String> func1 = Object::toString;
        UnaryOperator<String> func2 = s -> s + "hours";
        Function<String, String> func3 = s -> "'" + s + "'";
        Function<Integer, String> composedFunc = func2.compose(func1).andThen(func3);
        example.applyComposedFunction(5, composedFunc);
    }

    public void applyComposedFunction(Integer input, Function<Integer, String> func) {
        String output = func.apply(input);
        LOGGER.info("{} after applying composed function is {}", input, output);
    }
}
