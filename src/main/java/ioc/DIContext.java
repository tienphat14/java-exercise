package ioc;

import java.util.HashSet;
import java.util.Set;

public class DIContext {

    private final Set<Object> serviceInstances = new HashSet<>();

    public static DIContext createContextForPackage(String rootPackageName) throws Exception {
        Set<Class<?>> allClassesInPackage = ClassPathScanner.getAllClassesInPackage(rootPackageName);
        // TODO implement with reflection, don't forget to set accessible
        // Step 1: find all service classes in allClassesInPackage

        // Step 2: create an instance for each service(Class.getConstructor())
        // and add it to the serviceInstances set

        // Step 3: check each field in each service instance
        // if that field is a reference to another service
        // find an appropriate one in serviceInstances
        // and wire to that field
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    public <T> T getServiceInstance(Class<T> serviceClass){
        // TODO
        throw new UnsupportedOperationException("This method is not implemented yet");
    }
}