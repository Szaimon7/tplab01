# Zadanie 6 — narzędzie UML i diagram klas

W VS Code 1.141.1 jest już zainstalowane wbudowane rozszerzenie Mermaid Markdown Features.
Obsługa Mermaid jest częścią VS Code od wersji 1.121. Narzędzie wymagane do zadania
jest więc dostępne w używanym środowisku.

## Jak pokazać diagram

1. W VS Code otwórz folder GitLab03-published.
2. Po lewej rozwiń docs i otwórz uml.md.
3. Naciśnij Ctrl+Shift+V — otworzy się podgląd Markdown z diagramem.
4. Aby oglądać kod i diagram obok siebie: Ctrl+K, następnie V.
5. Jeśli widzisz sam tekst, Ctrl+Shift+P → Markdown: Open Preview to the Side.

Użyj zwykłego podglądu Markdown. Źródło diagramu znajduje się w bloku kodu oznaczonym jako Mermaid.
Nie trzeba uruchamiać aplikacji Java ani Mavena, żeby zobaczyć UML.

## Pliki

- uml.md — dokument z diagramem i wyjaśnieniem.
- uml.mmd — sam kod Mermaid, gotowy do dalszej edycji.
- uml.svg — wygenerowany diagram wektorowy, do otwarcia w przeglądarce lub wstawienia do sprawozdania.

Jeśli podgląd Markdown nie działa, można od razu otworzyć uml.svg w przeglądarce.
Źródło Mermaid pozostaje edytowalne.

## Co przedstawia diagram

App obsługuje użytkownika w konsoli, TaskService tworzy i przechowuje listę,
a Task przechowuje tytuł i stan ukończenia jednego zadania.

- Prostokąt przedstawia klasę. Zawiera nazwę, pola oraz metody.
- + oznacza element publiczny, - prywatny.
- Przerywana strzałka oznacza, że jedna klasa korzysta z drugiej.
- Wypełniony romb przy TaskService przedstawia kompozycję: serwis tworzy i przechowuje zadania.
- 1 oraz 0..* oznaczają jeden serwis i dowolną liczbę zadań, także pustą listę.
- Podkreślona metoda jest statyczna. W kodzie Mermaid oznacza ją $ na końcu deklaracji.

## Co powiedzieć prowadzącemu

„Używam Mermaid w VS Code do tworzenia diagramów UML z tekstowego opisu.
Diagram klas przedstawia strukturę aplikacji. App korzysta z TaskService,
a TaskService tworzy i przechowuje obiekty Task. Pokazuję pola, metody
oraz zależności między trzema klasami.”

Przy prezentacji zmień opis strzałki, np. wywoluje na korzysta z, zapisz plik
i pokaż zmianę w podglądzie. Potem przywróć poprzedni opis.

## Sprawdzenie

Potwierdzono obecność wbudowanego rozszerzenia w instalacji VS Code.
Diagram wyrenderowano lokalnie przy użyciu silnika Mermaid dostępnego w
zainstalowanym Markdown Preview Enhanced, sprawdzono trzy klasy i zapisano SVG.
Nie sprawdzano automatycznie podglądu w aktywnym oknie VS Code; uruchom go
według kroków powyżej.

Dokumentacja:
https://code.visualstudio.com/updates/v1_121
https://mermaid.js.org/syntax/classDiagram.html
