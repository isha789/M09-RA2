
public class PrincipalFutbol {

    public static void main(String[] args) {

        Futbolista[] players = new Futbolista[Futbolista.NUM_JUGADORS];

        String[] names = {
            "Piqué", "Vinicius", "Torres", "Ramos",
            "Ronaldo", "Lewan", "Belli", "Arnau",
            "Aspas", "Messi", "Mbapé"
        };

        // 1. Create all threads
        for (int i = 0; i < players.length; i++) {
            players[i] = new Futbolista(names[i]);
        }

        System.out.println("Inici dels xuts --------------------");

        // 2. Start all threads
        for (int i = 0; i < players.length; i++) {
            players[i].start();
        }

        // 3. Wait for all threads to finish
        for (int i = 0; i < players.length; i++) {
            try {
                players[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("Fi dels xuts -----------------------");

        // 4. Display statistics
        System.out.println("--- Estadístiques -----");

        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i].getName() + " -> "
                    + players[i].getGols() + " gols");
        }
    }
}
