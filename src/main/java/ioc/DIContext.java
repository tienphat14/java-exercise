package ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DIContext {

    private final Set<Object> serviceInstances = new HashSet<>();

    public static DIContext createContextForPackage(String rootPackageName) throws Exception {
        Set<Class<?>> allClassesInPackage = ClassPathScanner.getAllClassesInPackage(rootPackageName);
        Set<Class<?>> serviceClasses = new HashSet<>();
        for (Class<?> aClass : allClassesInPackage) {
            if (aClass.isAnnotationPresent(MyService.class)) {
                serviceClasses.add(aClass);
            }
        }
        return new DIContext(serviceClasses);
    }

    public DIContext(Collection<Class<?>> serviceClasses) throws Exception {
        createServiceInstances(serviceClasses);
        for (Object serviceInstance : serviceInstances) {
            wireService(serviceInstance);
        }
    }

    public <T> T getServiceInstance(Class<T> serviceClass){
        for(Object serviceInstance : this.serviceInstances){
            if(serviceClass.isInstance(serviceInstance)){
                return (T)serviceInstance;
            }
        }
        return null;
    }

    private void createServiceInstances(Collection<Class<?>> serviceClasses) throws Exception {
        for (Class<?> serviceClass : serviceClasses) {
            Constructor<?> constructor = serviceClass.getConstructor();
            boolean accessible = constructor.isAccessible();
            constructor.setAccessible(true);
            Object serviceInstance = constructor.newInstance();
            this.serviceInstances.add(serviceInstance);
            constructor.setAccessible(accessible);
        }
    }

    private void wireService(Object serviceInstance) throws Exception {
        for (Field field : serviceInstance.getClass().getDeclaredFields()){
            if (!field.isAnnotationPresent(MyAutoWired.class)){
                continue;
            }
            Class<?> fieldType = field.getType();
            boolean accessible = field.isAccessible();
            field.setAccessible(true);
            for (Object matchPartner : this.serviceInstances){
                if (fieldType.isInstance(matchPartner)){
                    field.set(serviceInstance, matchPartner);
                }
            }
            field.setAccessible(accessible);
        }
    }
}