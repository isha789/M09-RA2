
public class Futbolista extends Thread {

    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

    private int gols;
    private int tirades;

    public Futbolista(String name) {
        super(name);

        gols = 0;
        tirades = 0;
    }

@Override
public void run() {

    for (int i = 0; i < NUM_TIRADES; i++) {

        tirades++;

        double random = Math.random();

        if (random < PROBABILITAT) {
            gols++;
        }
    }
}

public int getGols() {
    return gols;
}

public int getTirades() {
    return tirades;
}


}
