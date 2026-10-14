# Zadanie 5 — Checkstyle

Checkstyle sprawdza zgodność kodu z regułami stylu. W projekcie kontroluje m.in.
nazwy, odstępy, wcięcia, klamry, nieużywane importy i długość linii.
Reguły są w config/checkstyle.xml.

## VS Code — pokaz krok po kroku

Zainstalowane rozszerzenie: Checkstyle for Java (shengchen.vscode-checkstyle), wersja 1.4.2.
Konfigurację zapisano w .vscode/settings.json. Maven i rozszerzenie używają Checkstyle 9.3.

1. Otwórz folder GitLab03-published w VS Code.
2. Ctrl+Shift+P → Developer: Reload Window, aby aktywować nową wtyczkę.
3. Otwórz TaskService.java.
4. Ctrl+Shift+P → Checkstyle: Check Code with Checkstyle.
5. Ctrl+Shift+M otwiera Problems, gdzie pojawiają się zgłoszenia.

Jeśli konfiguracja nie została rozpoznana, Ctrl+Shift+P → Checkstyle: Set the Checkstyle
Configuration File i wybierz config/checkstyle.xml. Wymagane rozszerzenie Java od Red Hat
jest już zainstalowane. Analiza automatyczna jest włączona.

## Próbny błąd

W metodzie addTask zmniejsz wcięcie instrukcji tasks.add z ośmiu do czterech spacji:

```java
    public void addTask(final String title) {
    tasks.add(new Task(title));
    }
```

Zapisz plik i uruchom analizę. Reguła Indentation zgłosi niewłaściwe wcięcie.
Popraw instrukcję, dodając cztery spacje:

```java
    public void addTask(final String title) {
        tasks.add(new Task(title));
    }
```

Po zapisaniu i ponownej analizie zgłoszenie powinno zniknąć.
Przywróć poprawną wersję przed oddaniem projektu.

## Maven

```powershell
mvn checkstyle:check
```

Naruszenie stylu powoduje niepowodzenie kontroli. Po poprawce otrzymasz BUILD SUCCESS.
Raport HTML możesz wygenerować przez mvn checkstyle:checkstyle, a następnie
otworzyć target/site/checkstyle.html.

## Co powiedzieć prowadzącemu

„Zainstalowałem Checkstyle w VS Code i wskazałem konfigurację projektu.
Narzędzie wykryło niepoprawne wcięcie. Po poprawieniu liczby spacji kontrola
przeszła bez naruszeń. PMD analizuje wybrane problemy w kodzie, a Checkstyle
pilnuje wybranych zasad stylu. Oba narzędzia mogę uruchomić również przez Maven.”

## Weryfikacja

Sprawdzono faktyczny błąd wcięć w TaskService.java i jego poprawkę przez Maven
oraz silnik Checkstyle dołączony do rozszerzenia. Po poprawce nie ma naruszeń.
Instalację rozszerzenia potwierdzono przez listę zainstalowanych rozszerzeń.
Wyświetlanie zgłoszeń w panelu Problems sprawdź przy pokazie opisanym powyżej.

Dokumentacja:
https://marketplace.visualstudio.com/items?itemName=shengchen.vscode-checkstyle
https://maven.apache.org/plugins/maven-checkstyle-plugin/usage.html
