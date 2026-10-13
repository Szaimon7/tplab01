package pl.edu.tplab;

import java.util.ArrayList;
import java.util.List;

/** Stores tasks and applies operations to them. */
public final class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(final String title) {
        tasks.add(new Task(title));
    }

    public void completeTask(final int taskNumber) {
        if (taskNumber < 1 || taskNumber > tasks.size()) {
            throw new IllegalArgumentException("Nie ma zadania o takim numerze.");
        }
        tasks.get(taskNumber - 1).complete();
    }

    public List<Task> getTasks() {
        return List.copyOf(tasks);
    }
}
