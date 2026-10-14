# Weryfikacja projektu

Sprawdzenie wykonano 14 października 2026 r. dla konfiguracji uruchamiającej PMD i Checkstyle w fazie `verify`.

## Aktualny kod

| Polecenie | Wynik |
|---|---|
| `mvn clean verify` | BUILD SUCCESS; kompilacja, pakowanie i obie kontrole zakończone pomyślnie. |
| `mvn pmd:check` | Brak naruszeń skonfigurowanych reguł PMD. |
| `mvn checkstyle:check` | 0 naruszeń Checkstyle. |

## Sprawdzenie wykrywania błędów

Przypadki wykonano na osobnej kopii roboczej. Nie dodano ich do kodu aplikacji.

| Przypadek | Oczekiwane zachowanie | Wynik |
|---|---|---|
| Brak średnika w kodzie Java | Kompilacja przerywa budowanie. | Zgodny |
| Nieużywana zmienna lokalna | PMD zgłasza UnusedLocalVariable; verify kończy się niepowodzeniem. | Zgodny |
| Pusty blok catch | PMD zgłasza EmptyCatchBlock; verify kończy się niepowodzeniem. | Zgodny |
| Niepoprawne wcięcie | Checkstyle zgłasza Indentation; verify kończy się niepowodzeniem. | Zgodny |
| Brak klamer przy if | Checkstyle zgłasza NeedBraces; verify kończy się niepowodzeniem. | Zgodny |
| Nieużywana zmienna w src/test/java | PMD wykrywa naruszenie także w kodzie testowym. | Zgodny |
| Niepoprawne wcięcie w src/test/java | Checkstyle wykrywa naruszenie także w kodzie testowym. | Zgodny |

Maven domyślnie przerywa przebieg po pierwszym błędzie. Jeśli PMD odrzuci budowanie, późniejszy krok Checkstyle nie musi zostać wykonany; osobne polecenia pozwalają sprawdzić oba narzędzia niezależnie.

## Działanie aplikacji

Sprawdzono gotowy JAR w czterech scenariuszach:

- dodanie dwóch zadań, ukończenie pierwszego i wyświetlenie poprawnych stanów;
- wyświetlenie pustej listy;
- tytuł z samych spacji, numery -1, 0 i spoza zakresu, tekst zamiast numeru oraz nieznana opcja;
- zakończenie wejścia podczas podawania tytułu.

Wszystkie scenariusze zakończyły się zgodnie z oczekiwaniami. Nie stwierdzono problemu wymagającego zmiany aplikacji w sprawdzonym zakresie.

Projekt nie zawiera testów JUnit. Weryfikacja działania wykorzystuje scenariusze wejścia i wyjścia konsoli. Wyniki PMD oraz Checkstyle odnoszą się do reguł z konfiguracji projektu.
