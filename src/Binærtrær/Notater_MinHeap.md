# Min og max heap

Min heap, eller minimumshaug, er et komplett binærtre der hver foreldrenode er mindre enn sine barn, og roten er treets minste verdi.
Minimumstre er IKKE det samme som minimumshaug - treet trenger ikke være komplett!

* komplett tre - hvert nivå fylt, og det siste er fylt fra venstre side
* min heap er en måte å implementere prioritetskø på

![img_26.png](Bilder/img_26.png)
![img_27.png](Bilder/img_27.png)

Max heap, makismumshaug, er akkurat det samme, men vi flytter større verdier oppover, slik at alle foreldre er større enn sine barn, 
og roten er den største verdien i hele treet. Typisk er det fordi vi ønsker en struktur som garanterer at vi alltid henter ut største element.

## Innlegging
Vi legger noden inn i bunnen, første fra venstre på nederste nivå (komplett tre).
Så sammenligner vi oppover for å sikre at den aldri er mindre enn sin forelder, og finner dens endelige plass.

Innlegging er O(log n) fordi vi legger inn (O1) og så i snitt "bobler" den innlagte verdien opp log n nivåer (treets høyde).

![img_25.png](Bilder/img_25.png)
## Fjerning
Typisk ønsker vi å fjerne nettopp den minste verdien - det er derfor vi bruker minHeap.
Vi tar ut rotnoden ved å bytte den med neste i inorden (standard for fjerning av alt annet enn bladnoder i binærtrær).
Deretter beveger vi denne noden nedover ved å alltid bytte den ut med den minste av sine to barn.

Fjerning er i snitt O(log n) fordi vi fjerner øverste ved å bytte med neste i inorden O(1), og så bobler denne endover log n nivåer (treets høyde).

# Turneringstrær