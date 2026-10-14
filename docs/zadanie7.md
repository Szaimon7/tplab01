# Dokumentacja aplikacji — lista zadań

## Cel i funkcjonalność

Konsolowa aplikacja Java umożliwia dodawanie zadań, wyświetlanie listy oraz oznaczanie wybranych zadań jako ukończonych. Projekt łączy Maven, Git, PMD, Checkstyle i diagram UML.

Dane są przechowywane w pamięci podczas działania programu. Zamknięcie aplikacji usuwa bieżącą listę.

## Struktura aplikacji

| Klasa | Odpowiedzialność |
|---|---|
| `App` | Punkt wejścia programu, odczyt poleceń z konsoli i wyświetlanie wyników. |
| `TaskService` | Przechowywanie listy, tworzenie zadań i oznaczanie ich jako ukończonych. |
| `Task` | Tytuł zadania oraz jego stan ukończenia. |

Kod znajduje się w `src/main/java/pl/edu/tplab`.

Dodanie zadania przebiega następująco: `App` odczytuje tytuł, wywołuje `TaskService.addTask`, a serwis tworzy obiekt `Task` i dodaje go do listy. Ukończenie zadania polega na wywołaniu `TaskService.completeTask`, które zmienia stan wskazanego obiektu przez metodę `Task.complete`.

Numeracja zadań w interfejsie zaczyna się od 1. Serwis sprawdza zakres numeru przed odczytem elementu listy.

## Wymagania środowiska

- JDK 17 lub nowszy.
- Maven.
- Git do pobrania projektu i pracy z historią.

Pierwsze budowanie wymaga dostępu do repozytorium Maven w celu pobrania wtyczek.

## Budowanie i uruchomienie

Polecenia należy wykonać w katalogu zawierającym `pom.xml`:

```powershell
mvn clean verify
java -jar target/lista-zadan-1.0.0.jar
```

Faza `verify` obejmuje kompilację, utworzenie pliku JAR oraz kontrole PMD i Checkstyle. Do uruchomienia gotowego JAR-a wystarczy Java.

## Obsługa programu

| Opcja | Działanie | Następne dane |
|---|---|---|
| `1` | Dodanie zadania | Tytuł zadania |
| `2` | Wyświetlenie listy | Brak |
| `3` | Oznaczenie zadania jako ukończonego | Numer zadania |
| `0` | Zakończenie programu | Brak |

Każdy wpis zatwierdza się klawiszem Enter. Oznaczenie `[ ]` wskazuje zadanie otwarte, a `[x]` ukończone.

Przykładowy wynik po dodaniu dwóch zadań i ukończeniu pierwszego:

```text
1. [x] Nauka Java
2. [ ] Cwiczenie Maven
```

Program obsługuje pusty tytuł, nieistniejący numer zadania, nieprawidłowy format numeru oraz nieznaną opcję menu. Błędne dane są sygnalizowane komunikatem w konsoli.

## Wykorzystane technologie

| Technologia | Zastosowanie |
|---|---|
| Maven | Konfiguracja budowania w `pom.xml`, kompilacja dla Java 17 i tworzenie wykonywalnego JAR-a. |
| Git | Wersjonowanie projektu oraz historia dwóch gałęzi i ich scalenia. |
| PMD | Analiza według reguł z `config/pmd.xml`. |
| Checkstyle | Kontrola stylu według `config/checkstyle.xml`, w tym wcięć, nazw i klamer. |
| UML | Diagram trzech klas i ich powiązań w [uml.md](uml.md). |

Analizatory można uruchomić oddzielnie:

```powershell
mvn pmd:check
mvn checkstyle:check
```

Konfiguracja rozszerzeń VS Code znajduje się w `.vscode/settings.json`.

## Weryfikacja

Budowanie poleceniem `mvn clean verify` zakończyło się wynikiem `BUILD SUCCESS`. Skonfigurowane reguły PMD i Checkstyle nie zgłosiły naruszeń.

Sprawdzono działanie gotowego JAR-a w czterech scenariuszach:

- dodawanie zadań, ukończenie wybranego zadania i wyświetlenie stanu listy;
- wyświetlenie pustej listy;
- obsługa błędnych danych wejściowych;
- zakończenie strumienia wejścia.

Weryfikacja działania obejmuje scenariusze konsolowe. Projekt nie zawiera testów jednostkowych JUnit.
