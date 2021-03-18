package ioc;

public class IoCExample {

    public static void main(String[] args) throws Exception {
        DIContext context = createContext();
        run(context);
    }

    private static DIContext createContext() throws Exception {
        String rootPackageName = IoCExample.class.getPackage().getName();
        return DIContext.createContextForPackage(rootPackageName);
    }

    private static void run(DIContext context){
        PrintService printService = context.getServiceInstance(PrintService.class);
        printService.print();
    }
}
