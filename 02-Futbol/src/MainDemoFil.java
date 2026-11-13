
public class MainDemoFil {

    public static void main(String[] args) {

        Thread current = Thread.currentThread();

        System.out.println("MainDemoFil.main:");
        System.out.println("Prioritat -> " + current.getPriority()
                + ", Nom -> " + current.getName());
        System.out.println("toString() -> " + current.toString());
    }
}
