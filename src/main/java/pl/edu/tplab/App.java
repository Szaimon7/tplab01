package pl.edu.tplab;

import java.util.List;
import java.util.Scanner;

/** Console user interface. Tasks are kept in memory until exit. */
public final class App {
    private App() {
    }

    public static void main(final String[] args) {
        final TaskService service = new TaskService();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println("1 - dodaj, 2 - pokaz, 3 - ukoncz, 0 - wyjdz");
                if (!scanner.hasNextLine()) {
                    break;
                }
                final String choice = scanner.nextLine();
                try {
                    switch (choice) {
                        case "1":
                            System.out.println("Podaj tytul:");
                            if (scanner.hasNextLine()) {
                                service.addTask(scanner.nextLine());
                            }
                            break;
                        case "2":
                            printTasks(service.getTasks());
                            break;
                        case "3":
                            System.out.println("Podaj numer zadania:");
                            if (scanner.hasNextLine()) {
                                service.completeTask(Integer.parseInt(scanner.nextLine()));
                            }
                            break;
                        case "0":
                            running = false;
                            break;
                        default:
                            System.out.println("Nieznana opcja.");
                            break;
                    }
                } catch (IllegalArgumentException exception) {
                    System.out.println("Blad: " + exception.getMessage());
                }
            }
        }
    }

    private static void printTasks(final List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("Lista jest pusta.");
        }
        for (int index = 0; index < tasks.size(); index++) {
            final Task task = tasks.get(index);
            final String status = task.isCompleted() ? "[x]" : "[ ]";
            System.out.println((index + 1) + ". " + status + " " + task.getTitle());
        }
    }
}
