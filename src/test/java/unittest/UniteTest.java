package unittest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UniteTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UniteTest.class);

    @ClassRule
    public static MyTestRule myClassTestRule = new MyTestRule("Class level");

    @Rule
    public MyTestRule myMethodTestRule = new MyTestRule("Method level");

    @BeforeClass
    public static void setUp() {
        LOGGER.info("Setup");
    }

    @Before
    public void before() {
        LOGGER.info("Before each test");
    }

    @Test
    public void test1() {
        LOGGER.info("Inside test case 1");
    }

    @Test
    public void test2() {
        LOGGER.info("Inside test case 2");
    }

    @AfterClass
    public static void tearDown() {
        LOGGER.info("Tear Down");
    }

    @After
    public void after() {
        LOGGER.info("After each test");
    }
}