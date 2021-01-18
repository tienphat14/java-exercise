package helpfulfeatures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(LambdaExample.class);

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("One", "Two", "Three"));
        ZeroParamFuncInterface zeroParamFunc = () -> LOGGER.info("Hello there");
        SingleParamFuncInterface<Integer, Integer> singleParamfunc = a -> a * a;
        MultipleParamsFuncInterface multipleParamsfunc = (a, b) -> {
            LOGGER.info("Summing {} and {}", a, b);
            return a + b;
        };

        LambdaExample example = new LambdaExample();
        example.method1(zeroParamFunc);
        example.method1(() -> LOGGER.info("Hello World"));
        example.method1(LambdaExample::saySomethingStatic);
        example.method1(example::saySomethingNonStatic);
        LOGGER.info("************************************************************");

        LOGGER.info("Square of 10 is {}", example.method2(10, singleParamfunc));
        LOGGER.info("************************************************************");

        LOGGER.info("Sum of 10 and 20 is {}", example.method3(10, 20, multipleParamsfunc));
        LOGGER.info("10 compare to 20 is {}", example.method3(10, 20, Integer::compare));
        LOGGER.info("************************************************************");

        example.method4("Hello", Message::new);
        LOGGER.info("************************************************************");

        LOGGER.info("Before sort {}", stringList);
        stringList.sort(String::compareTo);
        LOGGER.info("After sort {}", stringList);
    }

    public static void saySomethingStatic(){
        LOGGER.info("Hello, this is a static method.");
    }

    public void saySomethingNonStatic(){
        LOGGER.info("Hello, this is a non-static method.");
    }

    public void method1(ZeroParamFuncInterface zeroParamFunc) {
        zeroParamFunc.abstractMethod();
    }

    public int method2(int a, SingleParamFuncInterface<Integer, Integer> func) {
        return func.abstractMethod(a);
}

    public int method3(int a, int b, MultipleParamsFuncInterface func) {
        return func.abstractMethod(a, b);
    }

    public Message method4(String s, SingleParamFuncInterface<String, Message> func) {
        return func.abstractMethod(s);
    }
}

@FunctionalInterface
interface ZeroParamFuncInterface {
    void abstractMethod();
}

@FunctionalInterface
interface SingleParamFuncInterface<T, U> {
    U abstractMethod(T t);
}

@FunctionalInterface
interface MultipleParamsFuncInterface {
    int abstractMethod(int a, int b);
}

class Message {
    private static Logger LOGGER = LoggerFactory.getLogger(Message.class);
    public Message(String s) {
        LOGGER.info("Inside Message class: {}", s);
    }
}
