package helpfulfeatures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericExample.class);

    public static void main (String[] args) {
        Test<String, Integer> testObj1 = new Test<>("Hello", 15);
        String s1 = testObj1.getObjT();
        Integer n1 = testObj1.getObjU();
        LOGGER.info("Object [testObj1] has type {}", testObj1.getClass());
        LOGGER.info("Object [T-{}] has type {}", s1, s1.getClass());
        LOGGER.info("Object [U-{}] has type {}", n1, n1.getClass());
        LOGGER.info("************************************************************");

        Test testObj2 = new Test("Welcome", 100L);
        String s2 = (String) testObj2.getObjT();
        Long n2 = (Long) testObj2.getObjU();
        LOGGER.info("Object [testObj2] has type {}", testObj2.getClass());
        LOGGER.info("Object [T-{}] has type {}", s2, s2.getClass());
        LOGGER.info("Object [U-{}] has type {}", n2, n2.getClass());
        LOGGER.info("************************************************************");

        LOGGER.info("Test and TestChild have same class: {}", testObj1.isSameClassMethod(testObj1, new TestChild()));
        LOGGER.info("Test<String, Integer> and Test have same class: {}", testObj1.isSameClassMethod(testObj1, testObj2));
        LOGGER.info("Test<String, Integer> and Test<Integer, String> have same class: {}", testObj1.isSameClassMethod(testObj1, new Test<Integer, String>()));
        LOGGER.info("************************************************************");

        testObj1.uppberBoundedMethod(testObj1);
        testObj1.uppberBoundedMethod(testObj2);
        testObj1.uppberBoundedMethod(new TestChild());
        testObj1.lowerBoundedWildcardMethod(new ArrayList<TestChild>());
        testObj1.lowerBoundedWildcardMethod(new ArrayList<Test>());
        testObj1.lowerBoundedWildcardMethod(new ArrayList<Object>());
    }
}

class Test<T, U> {

    private static Logger LOGGER = LoggerFactory.getLogger(Test.class);

    private T objT;
    private U objU;

    public Test() {
    }

    public Test(T objT, U objU) {
        this.objT = objT;
        this.objU = objU;
    }

    public boolean isSameClass(T objT, U objU) {
        return objT.getClass().equals(objU.getClass());
    }

    public <S, V> boolean isSameClassMethod(S objS, V objU) {
        return objS.getClass().equals(objU.getClass());
    }

    public <S extends Test> void uppberBoundedMethod(S objS) {
        LOGGER.info("This method only allow instance of Test class or its subtypes: {}", objS.getClass());
    }

    public void lowerBoundedWildcardMethod(List<? super TestChild> list) {
        LOGGER.info("This method only allow a list of TestChild or its supertypes: {}", list.getClass());
    }

    public T getObjT() {
        return objT;
    }

    public U getObjU() {
        return objU;
    }
}

class TestChild extends Test {}