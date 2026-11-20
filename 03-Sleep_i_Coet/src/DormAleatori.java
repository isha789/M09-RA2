
public class DormAleatori extends Thread {

    private long startTime;

    public DormAleatori(String name) {

        super(name);

        startTime = System.currentTimeMillis();
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            int interval = (int) (Math.random() * 1000);

            long totalTime = System.currentTimeMillis() - startTime;

            System.out.println(getName() + "(" + i + ") a dormir "
                    + interval + "ms total " + totalTime + "ms");

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public static void main(String[] args) {

        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        System.out.println("-- Fi de main -----------");
    }
}
