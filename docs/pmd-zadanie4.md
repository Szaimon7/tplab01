# Zadanie 4 — PMD

PMD analizuje kod źródłowy bez uruchamiania aplikacji i szuka naruszeń wybranych reguł.
Projekt używa pięciu reguł z config/pmd.xml: nieużywane zmienne lokalne, prywatne pola
oraz metody, puste bloki catch i niezamykanie zasobów.

## VS Code

Zainstalowane rozszerzenie: PMD for Java (cracrayol.pmd-java), wersja 0.7.3.
Ustawienia projektu są w .vscode/settings.json. Analiza odbywa się przy otwieraniu
lub zapisywaniu pliku Java i korzysta z config/pmd.xml.

1. Otwórz folder projektu w VS Code przez File → Open Folder.
2. Jeśli rozszerzenie nie jest jeszcze aktywne, wykonaj Ctrl+Shift+P → Developer: Reload Window.
3. Otwórz TaskService.java.
4. Ctrl+Shift+P → PMD for Java: Static analysis on workspace.
5. Panel Problems otworzysz przez Ctrl+Shift+M. Kliknięcie zgłoszenia prowadzi do właściwej linii.

## Demonstracja dla prowadzącego

W metodzie addTask dodaj chwilowo linię:

```java
int temporaryCount = 42;
```

Zapisz plik i uruchom analizę. PMD powinno pokazać UnusedLocalVariable —
zmienna została utworzona, ale nie jest wykorzystywana.
Usuń linię, zapisz i uruchom analizę ponownie. Zgłoszenie powinno zniknąć.
Nie zostawiaj próbnego błędu w kodzie oddawanym do oceny.

Te same reguły sprawdzisz niezależnie od edytora:

```powershell
mvn pmd:check
```

Z błędem kontrola kończy się BUILD FAILURE. Po poprawce — BUILD SUCCESS.
Raport HTML wygenerujesz przez mvn pmd:pmd; znajduje się w target/site/pmd.html.

## Co powiedzieć

„Zainstalowałem PMD w VS Code i skonfigurowałem analizę według własnego zestawu reguł.
PMD sprawdza kod bez uruchamiania programu. Pokazałem nieużywaną zmienną, narzędzie
zgłosiło UnusedLocalVariable, a po usunięciu zmiennej analiza przeszła poprawnie.
Te same reguły uruchamiam przez Maven, więc mogę kontrolować projekt także poza IDE.”

PMD nie zastępuje testów. Brak naruszeń oznacza, że nie znaleziono problemów objętych
aktywnymi regułami — nie jest dowodem poprawności całej aplikacji.

## Weryfikacja

Próbę z błędem i poprawkę wykonano faktycznie przez Maven oraz silnik PMD dołączony
do rozszerzenia. Kod po próbie przywrócono. Rozszerzenie zawiera PMD 7.2.0,
a wtyczka Maven używa PMD 7.17.0; dla tego projektu i wskazanych reguł oba wyniki są zgodne.
Zapisane raporty nie oznaczają, że automatycznie sprawdzono wyświetlanie komunikatów
w panelu Problems — przy prezentacji uruchom polecenie rozszerzenia opisane wyżej.

Tutorial z listy dotyczy Eclipse. W VS Code odpowiednikiem instalacji wtyczki,
wybrania reguł i analizy kodu są powyższe kroki.

Źródła:
https://www.javatips.net/blog/pmd-in-eclipse-tutorial
https://marketplace.visualstudio.com/items?itemName=cracrayol.pmd-java
https://pmd.github.io/pmd/pmd_userdocs_tools_ide_plugins.html
https://maven.apache.org/plugins/maven-pmd-plugin/usage.html
