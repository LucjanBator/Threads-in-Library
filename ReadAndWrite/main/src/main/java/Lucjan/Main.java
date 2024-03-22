package Lucjan;

/**
 * The {@code Main} class represents the entry point of the application.
 */
/**
 * Klasa reprezentująca główną klasę programu.
 * Inicjuje bibliotekę i uruchamia wątki czytelników i pisarzy.
 */
public class Main {
    /**
     * Metoda główna programu.
     */
    public static void main(String[] args) {
        // Inicjalizacja biblioteki
        Biblioteka biblioteka = new Biblioteka();

        // Liczba czytelników i pisarzy do utworzenia
        int readers = 6;
        int writers = 2;

        // Tworzenie i startowanie wątków czytelników
        for (int i = 0; i < readers; i++) {
            Thread readerThread = new Thread(new Czytelnik(biblioteka));
            readerThread.start();
        }

        // Tworzenie i startowanie wątków pisarzy
        for (int i = 0; i < writers; i++) {
            Thread writerThread = new Thread(new Pisarz(biblioteka));
            writerThread.start();
        }
    }
}