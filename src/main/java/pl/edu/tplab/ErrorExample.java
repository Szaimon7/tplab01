package pl.edu.tplab;

/** Deliberately incorrect example for PMD and Checkstyle. */
public class ErrorExample {
    public void demonstrate() {
        int temporaryCount = 42;
        try {
            System.out.println("Przyklad do analizy");
        } catch (RuntimeException exception) {
        }
        if (true)
        System.out.println("Brak klamer i niepoprawne wciecie");
    }
}

