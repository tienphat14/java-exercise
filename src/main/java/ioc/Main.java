package ioc;

public class Main {

    public static void main(String[] args) throws Exception {
        DIContext context = createContext();
        run(context);
    }

    private static DIContext createContext() throws Exception {
        String rootPackageName = Main.class.getPackage().getName();
        return DIContext.createContextForPackage(rootPackageName);
    }

    private static void run(DIContext context) throws InstantiationException, IllegalAccessException {
        PrintService printService = context.getServiceInstance(PrintServiceImpl.class);
        printService.print();
    }
}
