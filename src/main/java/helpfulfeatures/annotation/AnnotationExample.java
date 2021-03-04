package helpfulfeatures.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnnotationExample.class);

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        AnnotationExample example = new AnnotationExample();
        example.run();
    }

    private void run() throws InvocationTargetException, IllegalAccessException {
        ChildClass childClass = new ChildClass("Ngoc Tuan", "Nguyen");
        Class<?> clazz = childClass.getClass();
        LOGGER.info("ChildClass is annotated with ClassAnnotation: {}", clazz.isAnnotationPresent(ClassAnnotation.class));

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MethodAnnotation.class)) {
                MethodAnnotation annotation = method.getAnnotation(MethodAnnotation.class);
                boolean methodAccessible = method.isAccessible();
                method.setAccessible(true);
                method.invoke(childClass, annotation.value());
                method.setAccessible(methodAccessible);
            }
        }

        for (Field field : clazz.getDeclaredFields()) {
            if(field.isAnnotationPresent(FieldAnnotation.class)) {
                FieldAnnotation annotation = field.getAnnotation(FieldAnnotation.class);
                int maxLength = annotation.maxLength();
                boolean fieldAccessible = field.isAccessible();
                field.setAccessible(true);
                Object fieldValue = field.get(childClass);
                field.setAccessible(fieldAccessible);
                LOGGER.info("Field[{}] has value=[{}]", field.getName(), fieldValue);
                if (fieldValue.toString().length() > maxLength) {
                    LOGGER.error("{}", annotation.message());
                } else {
                    LOGGER.info("<OK>");
                }
            }
        }
    }

    @ClassAnnotation
    private class ChildClass {

        private final Logger LOGGER = LoggerFactory.getLogger(ChildClass.class);

        @FieldAnnotation(message = "First name max length violated")
        private String firstName;

        @FieldAnnotation(message = "Last name max length violated", maxLength = 5)
        private String lastName;

        ChildClass(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @MethodAnnotation("Tuan")
        private void greating(String name) {
            LOGGER.info("Hello {}", name);
        }
    }
}
