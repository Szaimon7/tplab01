# Diagram klas

```mermaid
classDiagram
    class App {
        +main(String[] args)$ void
        -printTasks(List~Task~ tasks)$ void
    }
    class TaskService {
        -List~Task~ tasks
        +addTask(String title) void
        +completeTask(int taskNumber) void
        +getTasks() List~Task~
    }
    class Task {
        -String title
        -boolean completed
        +Task(String title)
        +getTitle() String
        +isCompleted() boolean
        +complete() void
    }
    App ..> TaskService : wywoluje
    App ..> Task : odczytuje
    TaskService "1" *-- "0..*" Task : tworzy i przechowuje
```

App obsługuje konsolę, TaskService zarządza listą, Task przechowuje dane jednego zadania.
Strzałka przerywana oznacza użycie klasy. Romb oznacza kompozycję:
TaskService tworzy i przechowuje zadania. 0..* oznacza dowolną liczbę zadań.
Znak + oznacza element publiczny, - prywatny, a $ metodę statyczną.
