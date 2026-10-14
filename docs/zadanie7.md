# Zadanie 7 — gotowa aplikacja Java

Aplikacja: konsolowa lista zadań. Użytkownik dodaje zadania, wyświetla listę
i oznacza wybrane zadanie jako ukończone. Dane są przechowywane w pamięci
przez czas działania programu.

## Wymagania zadania i ich realizacja

| Wymaganie | Realizacja |
|---|---|
| Co najmniej trzy współpracujące klasy | App, TaskService, Task w src/main/java/pl/edu/tplab. |
| Maven | pom.xml: kompilacja dla Java 17, tworzenie wykonywalnego JAR-a i kontrole w fazie verify. |
| Git | Repozytorium Szaimon7/tplab01, historia commitów i gałęzi, zapisany konflikt oraz rozwiązanie. |
| PMD | config/pmd.xml; mvn pmd:check oraz rozszerzenie PMD for Java w VS Code. |
| Checkstyle | config/checkstyle.xml; mvn checkstyle:check oraz rozszerzenie Checkstyle for Java. |
| UML | docs/uml.md, uml.mmd oraz wygenerowany uml.svg. |

## Jak współpracują klasy

App odczytuje polecenia z konsoli i wywołuje metody TaskService.
TaskService tworzy obiekty Task oraz przechowuje je na liście.
Task zawiera tytuł i informację o ukończeniu.

Przykład: wybieram 1 i wpisuję tytuł → App wywołuje addTask → TaskService
konstruuje Task i dodaje go do listy. Wybieram 3 i numer 1 → serwis wywołuje
complete na pierwszym zadaniu. Następne wyświetlenie pokazuje [x].

## Budowanie i uruchomienie

W terminalu otwartym w folderze projektu, obok pom.xml:

```powershell
mvn clean verify
java -jar target/lista-zadan-1.0.0.jar
```

Wymagany JDK 17 lub nowszy oraz Maven. Pierwsze budowanie wymaga dostępu
do internetu, aby pobrać wtyczki. Gotowy JAR nie wymaga Mavena do uruchomienia.

Menu:
- 1: dodaj, potem wpisz tytuł;
- 2: wyświetl listę;
- 3: ukończ, potem wpisz numer;
- 0: zakończ.

Każdą odpowiedź zatwierdź Enterem. [ ] oznacza zadanie otwarte, [x] ukończone.
Po zamknięciu aplikacji lista znika — projekt nie zapisuje jej w pliku ani bazie.

## Krótki pokaz prowadzącemu

1. Otwórz App.java, TaskService.java i Task.java. Wyjaśnij podział odpowiedzialności.
2. Uruchom mvn clean verify i pokaż BUILD SUCCESS. To kompilacja, JAR, PMD i Checkstyle w jednym przebiegu.
3. Uruchom JAR, dodaj „Nauka Java” i „Cwiczenie Maven”, oznacz pierwsze zadanie jako ukończone i wyświetl listę.
4. Pokaż pom.xml oraz pliki reguł w config.
5. Otwórz docs/uml.md i naciśnij Ctrl+Shift+V. Porównaj klasy w diagramie z kodem.
6. Pokaż repozytorium GitHub i git log --oneline --graph --all.

## Co powiedzieć

„Moja aplikacja to lista zadań. Ma trzy współpracujące klasy: App obsługuje
konsolę, TaskService zarządza listą, a Task przechowuje dane pojedynczego
zadania. Maven kompiluje i pakuje program, PMD sprawdza wybrane problemy
w kodzie, a Checkstyle sprawdza styl. Historia projektu jest w Git,
a diagram UML przedstawia strukturę klas.”

## Weryfikacja końcowa

Wykonano mvn clean verify: BUILD SUCCESS, brak naruszeń skonfigurowanych
reguł PMD oraz 0 naruszeń Checkstyle. Sprawdzono uruchomienie gotowego JAR-a
w czterech scenariuszach: dodawanie i ukończenie, pusta lista, błędne dane,
zakończenie strumienia wejścia.

Projekt nie zawiera testów JUnit. Powyższe sprawdzenie działania jest testem
scenariuszy konsolowych; sama faza mvn test nie wykonuje tu testów jednostkowych.
Brak naruszeń analizatorów dotyczy wybranego zestawu reguł i nie oznacza
udowodnienia poprawności programu dla wszystkich możliwych danych.

Pozostałe instrukcje: git-zadanie3.md, pmd-zadanie4.md,
checkstyle-zadanie5.md i uml-zadanie6.md.
