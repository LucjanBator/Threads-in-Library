package Lucjan;

/**
 * Klasa reprezentująca czytelnika w systemie bibliotecznym.
 * Czytelnicy wchodzą do biblioteki, czytają, a następnie wychodzą.
 */
public class Czytelnik implements Runnable {
    private Biblioteka biblioteka;

    /**
     * Konstruktor klasy Czytelnik.
     *
     * @param biblioteka Obiekt biblioteki, z którą jest powiązany czytelnik.
     */
    public Czytelnik(Biblioteka biblioteka) {
        this.biblioteka = biblioteka;
    }

    /**
     * Metoda run, reprezentująca działanie czytelnika w wątku.
     * Czytelnik wchodzi do biblioteki, czyta, a następnie wychodzi.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                biblioteka.Czytelnik_wchodzi();
                System.out.println("Czytelnik zaczyna czytać");
                Thread.sleep(250);
                biblioteka.Czytelnik_wychodzi();
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); //wątek zostanie oznaczony jako przerwany
                e.printStackTrace();
            }
        }
    }
}