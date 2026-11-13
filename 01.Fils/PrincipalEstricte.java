public class PrincipalEstricte {

    public static void main(String[] args) {

Fil juan = new Fil("Juan", 10);
Fil pepe = new Fil("Pepe", 10);

        juan.start();
        pepe.start();

        System.out.println("Termina thread main");
    }
}
