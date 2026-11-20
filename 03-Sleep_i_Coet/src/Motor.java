public class Motor extends Thread {

    private volatile int targetPower;
    private int currentPower;
    private volatile boolean powerReceived;

    public Motor(String name) {

        super(name);

        targetPower = 0;
        currentPower = 0;
        powerReceived = false;
    }

    public void setPotencia(int p) {

        targetPower = p;
        powerReceived = true;
    }

    @Override
    public void run() {

        while (true) {

            if (powerReceived) {

                int target = targetPower;

                if (currentPower < target) {

                    currentPower++;

                    showPower(target);

                } else if (currentPower > target) {

                    currentPower--;

                    showPower(target);
                }

                if (currentPower == 0 && target == 0) {
                    break;
                }
            }

            int interval = (int) (Math.random() * 1001) + 1000;

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private void showPower(int target) {

        String action;

        if (currentPower == target) {
            action = "FerRes";
        } else if (currentPower < target) {
            action = "Incre.";
        } else {
            action = "Decre.";
        }

        System.out.println(getName()
                + ": " + action
                + " Objectiu: " + target
                + " Actual: " + currentPower);
    }
}