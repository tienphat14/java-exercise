package ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Supporting to create context for ioc
 *
 */
public class DIContext {
    public static final Logger LOGGER =  LoggerFactory.getLogger(DIContext.class);
    private final Set<Object> iocServices = new HashSet<>();

    /**
     * Find all service classes in allClassesInPackage
     * Create an instance for each service
     * Check each field in each service instance. If that field is a reference to another service, find an appropriate one in serviceInstances and wire to that field
     *
     * @param rootPackageName
     * @return context
     * @throws Exception
     */
    public static DIContext createContextForPackage(String rootPackageName) throws Exception {
        DIContext context = new DIContext();
        Set<Class<?>> allClassesInPackage = ClassPathScanner.getAllClassesInPackage(rootPackageName);

        for (Class<?> clazz : allClassesInPackage) {
            if (clazz.getAnnotation(MyService.class) != null) {
                context.iocServices.add(clazz.getConstructor().newInstance());
            }
        }

        for (Object iocService : context.iocServices) {
            for (Field field : iocService.getClass().getDeclaredFields()) {
                if (field.getDeclaredAnnotation(MyAutoWired.class) != null) {
                    boolean originalFieldAccessibility = field.isAccessible();
                    Class<?> autowiredClass = field.getType();
                    Object autowiredObject = context.getServiceInstance(autowiredClass);
                    field.setAccessible(true);
                    field.set(iocService, autowiredObject);
                    field.setAccessible(originalFieldAccessibility);
                }
            }
        }
        return context;
    }

    /**
     * To get service instance
     *
     * @param serviceType
     * @param <T>
     * @return service instance and return null if not found object
     */
    public <T> T getServiceInstance(Class<T> serviceType) {
         for (Object object : this.iocServices) {
            if (serviceType.isAssignableFrom(object.getClass())) {
                return (T) object;
            }
        }
        return null;
    }
}