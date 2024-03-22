package Lucjan;

/**
 * Klasa reprezentująca pisarza w systemie bibliotecznym.
 * Pisarze wchodzą do biblioteki, piszą, a następnie wychodzą.
 */
public class Pisarz implements Runnable {
    private Biblioteka biblioteka;

    /**
     * Konstruktor klasy Pisarz.
     *
     * @param biblioteka Obiekt biblioteki, z którą jest powiązany pisarz.
     */
    public Pisarz(Biblioteka biblioteka) {
        this.biblioteka = biblioteka;
    }

    /**
     * Metoda run, reprezentująca działanie pisarza w wątku.
     * Pisarz wchodzi do biblioteki, pisze, a następnie wychodzi.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                biblioteka.Pisarz_wchodzi();
                System.out.println("Pisarz zaczyna pisać.");
                Thread.sleep(250);
                biblioteka.Pisarz_wychodzi();
                Thread.sleep(25);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
