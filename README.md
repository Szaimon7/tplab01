# Lista zadań — TPLab01

Projekt Java do laboratorium Technologie programowania. Konsolowa aplikacja umożliwia
dodawanie zadań, wyświetlanie listy i oznaczanie zadań jako ukończonych.
Dane pozostają w pamięci do zamknięcia programu.

## Narzędzia

Java 17 lub nowsza, Maven i Git. PMD oraz Checkstyle są skonfigurowane w pom.xml.
Diagram klas znajduje się w docs/uml.md.

## Budowanie i uruchomienie

```powershell
mvn clean verify
java -jar target/lista-zadan-1.0.0.jar
```

Menu: 1 — dodaj, 2 — pokaż, 3 — ukończ, 0 — wyjdź.

## Klasy

- App — obsługuje konsolę.
- TaskService — tworzy i przechowuje zadania.
- Task — przechowuje tytuł i stan zadania.

## Git — zadanie 3

Historia zawiera ćwiczenie z konfliktem: dwie gałęzie zmieniają tę samą linię
pliku docs/konflikt.txt, a commit scalający zapisuje rozwiązanie.
Obie gałęzie przygotowano na moim koncie jako ćwiczenie; nie są commitami kolegi.
Opis i polecenia do prezentacji znajdują się w docs/git-zadanie3.md.

Autor commitów: Szymon Wojtasik.

## Zadanie 7 — prezentacja aplikacji

Kompletna instrukcja uruchomienia, opis współpracy klas i plan demonstracji:
[docs/zadanie7.md](docs/zadanie7.md).

Projekt łączy Maven, Git, PMD, Checkstyle i UML. Polecenie `mvn clean verify`
buduje aplikację i sprawdza skonfigurowane reguły obu analizatorów.
