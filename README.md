# Lista zadań — TPLab01

Konsolowa aplikacja Java przygotowana w ramach laboratorium Technologie programowania. Umożliwia dodawanie zadań, wyświetlanie listy i oznaczanie zadań jako ukończonych.

## Uruchomienie

Wymagane: JDK 17 lub nowszy oraz Maven.

```powershell
mvn clean verify
java -jar target/lista-zadan-1.0.0.jar
```

Menu: `1` — dodaj, `2` — wyświetl, `3` — ukończ, `0` — zakończ. Dane pozostają w pamięci do zamknięcia programu.

## Organizacja projektu

- `src/main/java/pl/edu/tplab` — klasy `App`, `TaskService` i `Task`.
- `pom.xml` — konfiguracja kompilacji, pakowania i kontroli jakości.
- `config/pmd.xml` — reguły PMD.
- `config/checkstyle.xml` — reguły Checkstyle.
- `docs/uml.md` — diagram klas UML.
- `.vscode` — ustawienia i rekomendowane rozszerzenia edytora.

## Dokumentacja

[Opis aplikacji, wykorzystanych technologii i weryfikacji](docs/zadanie7.md)

[Diagram klas](docs/uml.md) · [Diagram SVG](docs/uml.svg)

## Historia Git

Repozytorium zawiera gałęzie `cwiczenie-a` i `cwiczenie-b` oraz commit scalający ich zmiany. Ćwiczenie dotyczyło konfliktu w pliku `docs/konflikt.txt`; przebieg zapisano w `docs/git-konflikt-przebieg.txt`. Obie gałęzie zostały przygotowane na jednym koncie.

```powershell
git log --oneline --graph --all
```
