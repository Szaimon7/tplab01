# Zadanie 3 — Git i GitHub

Projekt: lista zadań Java z Maven.
Konto publikacji: Szaimon7. Commity są zapisane jako Szymon Wojtasik.

## Wykonane ćwiczenie z konfliktem

1. Początkowa wersja docs/konflikt.txt zawierała jedno powitanie.
2. Gałąź cwiczenie-a zmieniła tę linię na powitanie aplikacji Java.
3. Gałąź cwiczenie-b, utworzona z tego samego punktu, zmieniła ją na powitanie aplikacji Maven.
4. Polecenie git merge cwiczenie-a na gałęzi cwiczenie-b zgłosiło rzeczywisty konflikt.
5. Wybrano treść łączącą obie wersje, usunięto znaczniki konfliktu i wykonano commit scalający.
6. Gałąź main otrzymała rozwiązany wynik wraz z historią obu wersji.

Obie wersje przygotowano na tym samym koncie jako ćwiczenie. Nie przypisano
żadnego commita koledze. Zapis poleceń i faktyczny komunikat CONFLICT są
w git-konflikt-przebieg.txt. Nie są to tylko przykładowe komunikaty.

## Co pokazać prowadzącemu

W terminalu otwartym w folderze projektu:

```powershell
git status
git remote -v
git log --oneline --graph --all
git show d52c5d1 --format=fuller --stat
```

- Status pokazuje, czy lokalne zmiany zostały zapisane.
- Remote origin wskazuje repozytorium GitHub.
- Graph pokazuje dwie gałęzie i ich scalenie.
- Commit d52c5d1 ma dwóch rodziców: to wynik scalenia, a nie zwykły zapis pliku.

Otwórz także git-konflikt-przebieg.txt i pokaż moment wystąpienia konfliktu
oraz końcowy plik konflikt.txt.

## Co powiedzieć

„Git przechowuje historię projektu, a GitHub udostępnia repozytorium online.
Zrobiłem dwa warianty tej samej linii na osobnych gałęziach. Podczas scalania
Git nie mógł sam wybrać treści, więc zgłosił konflikt. Połączyłem obie wersje,
dodałem rozwiązany plik przez git add i zapisałem commit scalający.”

Commit zapisuje wersję, branch oddziela linię pracy, push wysyła historię,
fetch pobiera historię z serwera, merge scala gałęzie. Pull pobiera i integruje zmiany.

## Współpraca z kolegą

Po podaniu loginu GitHub kolegi można zaprosić go do repozytorium z prawem zapisu.
Kolega musi zaakceptować zaproszenie. Samo wysłanie zaproszenia nie oznacza
jeszcze, że ma już aktywny dostęp. Przy pokazie trzeba sprawdzić ten stan w GitHub.

Kolega może sklonować repozytorium, utworzyć własną gałąź, zmienić tę samą linię
co druga osoba i zrobić commit oraz push. Wtedy można powtórzyć ćwiczenie z
rzeczywistymi zmianami dwóch osób. To jest dodatkowa współpraca; obecna historia
przedstawia konflikt dwóch gałęzi jednego konta.

## Integracja w VS Code

Otwórz folder tego projektu przez File → Open Folder. Panel Source Control
(Ctrl+Shift+G) rozpoznaje lokalne repozytorium Git. Historia i gałęzie są w plikach
repozytorium, więc nie trzeba tworzyć projektu od nowa ani używać osobnego IDE.

## Publikacja historii

Pliki i historia zostały opublikowane przez API GitHub na koncie Szaimon7.
Konflikt rzeczywiście wykonano lokalnie; na serwerze zachowano oba warianty,
układ rodziców commitów oraz rozwiązanie. Publikacja przez API nadała commitom
inne identyfikatory niż lokalny zapis w git-konflikt-przebieg.txt.
Polecenia powyżej wskazują opublikowany commit scalający.
