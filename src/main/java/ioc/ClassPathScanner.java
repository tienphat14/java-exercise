package ioc;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ClassPathScanner {

    public static Set<Class<?>> getAllClassesInPackage(String packageName) throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> directoryList = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            directoryList.add(new File(url.getFile()));
        }
        return getAllClassesInAllDirectory(packageName, directoryList);
    }

    private static Set<Class<?>> getAllClassesInAllDirectory(String packageName, List<File> directoryList) throws ClassNotFoundException {
        Set<Class<?>> classes = new HashSet<>();
        for (File directory : directoryList) {
            classes.addAll(getAllClassesInDirectory(packageName, directory));
        }
        return classes;
    }

    private static List<Class<?>> getAllClassesInDirectory(String packageName, File directory) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        if (Objects.isNull(files)) {
            return classes;
        }
        for (File file : files) {
            classes.addAll(getAllClasses(packageName, file));
        }
        return classes;
    }

    private static List<Class<?>> getAllClasses(String packageName, File file) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (file.isDirectory()) {
            String subPackageName = packageName + "." + file.getName();
            classes.addAll(getAllClasses(subPackageName, file));
        } else if (file.getName().endsWith(".class")) {
            String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
            classes.add(Class.forName(className));
        }
        return classes;
    }
}
