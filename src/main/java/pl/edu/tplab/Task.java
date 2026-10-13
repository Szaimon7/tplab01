package pl.edu.tplab;

/** One task and its completion state. */
public final class Task {
    private final String title;
    private boolean completed;

    public Task(final String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Tytul zadania nie moze byc pusty.");
        }
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        completed = true;
    }
}
