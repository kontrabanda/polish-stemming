# polish-stemming

Oprogramowanie służy to stemmingu plików (*.txt, *.csv) zawierających teksty napisane po polsku.
Wykorzystywany jest do tego pakiet morfologik:
* http://morfologik.blogspot.com/
* https://github.com/morfologik/morfologik-stemming

## Opis budowania

Do zbudowania projektu niezbędne jest narzędzie ant.
Z wykorzystaniem narzędzia można wykonać następujące komendy:
* ant compile (bądź sam ant) - kompilacja i zbudowanie folderu target,
* ant run - uruchomienie projektu,
* ant clean - czyszczenie projektu.

## Opis działania

Program tworzy na podstawie tekstowych plików wejściowych, pliki wyjściowe (również tekstowe) z tekstem po stemmingu.
* dane wejściowe należy umieścić w folderze: src/resource
* dane wyjściowe (po uruchomieniu programu) znajdują się w folderze: target/output

Progam pobiera tylko pliki o rozszerzeniu *.txt oraz *.csv.
