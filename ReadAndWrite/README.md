# System Biblioteczny

## Opis Projektu

Projekt reprezentuje prosty system biblioteczny napisany w języku Java, który obsługuje jednocześnie czytelników i pisarzy, korzystając z semaforów do kontrolowania dostępu do zasobów.

## Spis Treści

## Wymagania

- Java 17 (należy zainstalować JDK)
- Maven (opcjonalne, ale ułatwia zarządzanie projektem)

## Uruchamianie

1. **Przejdź do katalogu projektu:**

    Zadanie_3\ReadAndWrite

2. **Skompiluj i uruchom projekt:**

    mvn clean install

    To skompiluje projekt i utworzy plik JAR w folderze `target`.

3. **Uruchom aplikację**
   **Przejdź do folderu main\target a następnie:**

    java -jar main-1.0-SNAPSHOT.jar

    **Wyjście Ctrl + C**

## Struktura Projektu

- `src/main/java/Lucjan`: Katalog zawierający kod źródłowy Java.
  - `Main.java`: Klasa główna programu.
  - `Czytelnik.java`: Klasa reprezentująca czytelnika.
  - `Pisarz.java`: Klasa reprezentująca pisarza.
  - `Biblioteka.java`: Klasa implementująca system biblioteczny.

- `pom.xml`: Plik konfiguracyjny Maven.

## Autor

Lucjan Bator