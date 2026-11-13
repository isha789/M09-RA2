
public class Fil extends Thread {

    private int delay;

    private static final Object lock = new Object();
    private static String turn = "Juan";

    public Fil(String name) {
        this(name, 0);
    }

    public Fil(String name, int delay) {
        super(name);
        this.delay = delay;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 9; i++) {

            if (delay > 0) {

                synchronized (lock) {

                    while (!getName().equals(turn)) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    System.out.println(getName() + " " + i);

                    turn = getName().equals("Juan") ? "Pepe" : "Juan";

                    lock.notifyAll();
                }

                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

            } else {

                System.out.println(getName() + " " + i);

                long counter = 0;

                for (int j = 0; j < 1000; j++) {
                    counter += j;
                }
            }
        }

        System.out.println("Termina el fil " + getName());
    }
}
