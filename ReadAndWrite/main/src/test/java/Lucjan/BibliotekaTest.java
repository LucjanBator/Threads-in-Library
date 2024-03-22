package Lucjan;

import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotekaTest {

    @Test
    public void testCzytelnikWchodzi() throws InterruptedException {
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.Czytelnik_wchodzi();
        assertEquals(1, biblioteka.Ilosc_czytelnikow()); //sprawdzenie czy ilość czytelników równa 1
    }

    @Test
    public void testCzytelnikWychodzi() throws InterruptedException {
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.Czytelnik_wchodzi();
        biblioteka.Czytelnik_wychodzi();
        assertEquals(0, biblioteka.Ilosc_czytelnikow()); //sprawdzenie czy ilość czytelników równa 0
    }

    @Test
    public void testPisarzWchodzi() throws InterruptedException {
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.Pisarz_wchodzi();
        assertTrue(biblioteka.Ilosc_pisarzy()); //sprawdzenie czy jest pisarz w środku 'true'
    }

    @Test
    public void testPisarzWychodzi() throws InterruptedException {
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.Pisarz_wchodzi();
        biblioteka.Pisarz_wychodzi();
        assertFalse(biblioteka.Ilosc_pisarzy()); //sprawdzenie czy jest pisarz w środku 'false'
    }

    @Test
    public void testConcurrency() throws InterruptedException {
        Biblioteka biblioteka = new Biblioteka(); //tworzenie instancji Bibiloteki

        Thread readerThread = new Thread(() -> { //nowy wątek
            try {
                biblioteka.Czytelnik_wchodzi();
                Thread.sleep(2000);
                biblioteka.Czytelnik_wychodzi();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread writerThread = new Thread(() -> { //nowy wątek
            try {
                biblioteka.Pisarz_wchodzi();
                Thread.sleep(2000);
                biblioteka.Pisarz_wychodzi();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        readerThread.start();
        writerThread.start();

        readerThread.join(); //oczekiwanie na zakończenie wątku przed testem
        writerThread.join(); //oczekiwanie na zakończenie wątku przed testem

        assertEquals(0, biblioteka.Ilosc_czytelnikow()); //sprawdzenie czy liczba czytelnikow równa 0
        assertFalse(biblioteka.Ilosc_pisarzy()); //sprawdzenie czy pisarze 'false'
    }

    @Test
    public void testCzytelnikWychodziGdyInnyCzytelnikWchodzi() throws InterruptedException {
        Biblioteka biblioteka = new Biblioteka();
        biblioteka.Czytelnik_wchodzi();

        Thread czytelnikThread = new Thread(() -> { //nowy wątek
            try {
                biblioteka.Czytelnik_wchodzi();
                Thread.sleep(2000);
                biblioteka.Czytelnik_wychodzi();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        czytelnikThread.start();
        czytelnikThread.join();

        assertEquals(1, biblioteka.Ilosc_czytelnikow());
    }

    @Test(expected = InterruptedException.class)
    public void testCzytelnikWchodziInterruptedException() throws InterruptedException {
        Biblioteka biblioteka = new Biblioteka();
        Thread.currentThread().interrupt(); // Ustawienie flagi przerwania
        biblioteka.Czytelnik_wchodzi();
    }
}
