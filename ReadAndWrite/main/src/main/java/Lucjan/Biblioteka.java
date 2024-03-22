package Lucjan;

import java.util.concurrent.Semaphore;

/**
 * Klasa reprezentująca bibliotekę z systemem kontroli dostępu dla czytelników i pisarzy.
 * Używa semaforów do kontrolowania dostępu.
 */
public class Biblioteka {
    private final Semaphore czyt;
    private final Semaphore pisz;
    private boolean pisarz;
    private int czytelnik;

    /**
     * Konstruktor klasy Biblioteka. Inicjalizuje semafory i zmienne.
     */
    public Biblioteka() {
        czyt = new Semaphore(5); //liczba zwolnień semafora 5
        pisz = new Semaphore(1); //liczba zwolnień semafora 1
        pisarz = false;
        czytelnik = 0;
    }

    /**
     * Metoda zwracająca ilość czytelników aktualnie w bibliotece.
     *
     * @return Ilość czytelników w bibliotece.
     */
    public int Ilosc_czytelnikow() {
        return czytelnik;
    }

    /**
     * Metoda sprawdzająca czy w bibliotece jest obecnie pisarz.
     *
     * @return True, jeśli w bibliotece jest pisarz, w przeciwnym razie false.
     */
    public boolean Ilosc_pisarzy() {
        return pisarz;
    }

    /**
     * Metoda reprezentująca wejście czytelnika do biblioteki.
     * Używa semafora i synchronizacji.
     *
     * @throws InterruptedException Rzuca wyjątek w przypadku przerwania wątku.
     */
    public void Czytelnik_wchodzi() throws InterruptedException {
        synchronized (this) { //aby uniknąć równoczesnego dostępu wielu wątków do jednego zasobu
            while (pisarz || czytelnik >= 5) {
                wait(400);
            }
            czyt.acquire(); //dekrementacja semafora
            czytelnik++;    //inkrementacja liczby czytelnikow
            System.out.println("Czytelnik wchodzi.");
        }
    }

    /**
     * Metoda reprezentująca wyjście czytelnika z biblioteki.
     * Używa semafora i synchronizacji.
     */
    public void Czytelnik_wychodzi() {
        czyt.release(); //zwolnienie semaforu
        synchronized (this) {
            czytelnik--;
        }
        System.out.println("Czytelnik wychodzi.");
    }

    /**
     * Metoda reprezentująca wejście pisarza do biblioteki.
     * Używa semafora i synchronizacji.
     *
     * @throws InterruptedException Rzuca wyjątek w przypadku przerwania wątku.
     */
    public void Pisarz_wchodzi() throws InterruptedException {
        synchronized (this) {
            while (pisarz || czytelnik >= 1) {
                wait(400);
            }
            pisz.acquire();
            pisarz = true;
            System.out.println("Pisarz wchodzi.");
        }
    }

    /**
     * Metoda reprezentująca wyjście pisarza z biblioteki.
     * Używa semafora i synchronizacji.
     */
    public void Pisarz_wychodzi() {
        pisz.release();
        pisarz = false;
        System.out.println("Pisarz wychodzi.");
    }
}
