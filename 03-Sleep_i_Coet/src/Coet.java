import java.util.Scanner;

public class Coet {

    private Motor[] motors = new Motor[4];

    public Coet() {

        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor("Motor " + i);
        }
    }

    public void passaAPotencia(int p) {

        if (p >= 0 && p <= 10) {

            System.out.println("Passant a potència " + p);

            for (int i = 0; i < motors.length; i++) {
                motors[i].setPotencia(p);
            }

        } else {
            System.out.println("Error de valor");
        }
    }

    public void arranca() {

        for (int i = 0; i < motors.length; i++) {
            motors[i].start();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Coet coet = new Coet();

        coet.arranca();

        int power;

        do {

            power = scanner.nextInt();

            coet.passaAPotencia(power);

        } while (power != 0);

        scanner.close();
    }
}