# Algoritmer og kompleksitet

## Introduksjon til algoritmer
En algoritme er et sett med steg for å utføre en oppgave aller oppnå et mål.
Det er mange måter å nå målet på, ulike algoritmer, men noen er mer effektive en andre og bedre egnet i visse scenarioer.

En god algoritme består av: hastighet, destruktivitet, pålitelighet,nøyaktighet og forståelighet.

*Algoritmisk tankekang:*
* Klar problemstilling - definer input og output
* Et spesifikk sett med instruksjoner, i en bestemt rekkefølge
* Hvert steg er tydelig - skal ikke kunne brytes ned i mindre steg
* Bør gi et resultat - for å verifisere funksjon/oppførsel
* Må fullføre, og ikke ta uendelig tid

*Bekreft en god algoritme:*
* sjekk korrekthet
* sjekk effektivitet

## Det harmoniske tallet - Hn = log(n) + 0,577

## Kompleksitet - Big O notation
Vi ønsker å vite hvor effektiv en algoritme er, ikke bare i et best case-scenario, men i et average og worst case scenario.
Det som virkelig er av betydning er hvordan effektiviteten (output) skalerer, når input øker - særlig i avg. og worst case.
Når vi kjenner effektiviteten til en rekke algoritmer som kan brukes til å løse samme problem, kan vi velge den best egnede til det spesifikke scenarioet.

En algoritme består av mange ulike operasjoner, derfor har den en sammensatt kompleksitet, men vi er opptatt av den mest betydelige.
Vi finner hastigheten ved å teste på datasett av ulike størrelser, eller ved å telle antall operasjoner en algoritme utfører og lage en formel.
Antall operasjoner vil avhenge av både antall elementer, og rekkefølgen (permutasjonen).

I tillegg til tidskompleksitet (Big O notation), er det også space complexity (minnet algoritmen bruker når den kjører), men det er ikke tema i emnet.

### Konstante algoritmer O(1)
Vi kjører et konstant nr. operasjoner, uavhengig av hvor stort datasettet er.

### Lineære algoritmer O(n)
Antall operasjoner øker antall elementer (n), så dersom antall elementer dobles, dobles også tiden det tar.

### Kvadratiske algoritmer O(n^2)
Hvis vi dobler input, øker output eksponensielt! Skalerer dårlig.

### Logoritmiske algoritmer O(log n)
Vi halverer datasettet per operasjon, fx binærsøk og binærtrær

### Lineæritmiske algoritmer O(n log n)
Vi ganger n med log n. Det er litt verre enn O(n), men langt bedre skalering enn O(n^2).


## Søkealgoritmers kompleksitet
| Algoritme | Best case | Average case | Worst case |
|:----------|:---------:|:------------:|-----------:|
| Lineærsøk |           |              |            |
| Binærsøk  |           |              |            |

*Lineærsøk*
*Binærsøk*

## Sorteringsalgoritmers kompleksitet
| Algoritme      | Best case | Average case | Worst case |
|:---------------|:---------:|:------------:|-----------:|
| Insertion sort |     n     |     n^2      |        n^2 |
| Selection sort |    n^2    |     n^2      |        n^2 |
| Bubble sort    |     n     |     n^2      |        n^2 |
| Quick sort     | n  log n  |     n^2      |    n log n |
| Merge sort     |  n log n  |   n log n    |    n log n |

*Bubble sort* 
* Best - listen er alt sortert og vi trenger kun iterere gjennom 1 gang for å sjekke at den er det
* Worst: listen er sortert synkende, så hvert element må byttes

*Selection sort*
*Insertion sort*
*Merge sort*
*Quick sort*

## Datastrukturers kompleksitet
| Algoritme | Best case | Average case | Worst case |
|:----------|:---------:|:------------:|-----------:|
|           |           |              |            |
|           |           |              |            |
|           |           |              |            |

if - else if - else
Dersom det er større sannsynlighet for at ett av kriteriene er sanne,
bør dette tilfellet (if()) sjekkes først. Hvis første kriterie er sant vil ikke de neste sjekkes,
noe som reduserer antall operasjoner og effektiviserer programmet.
? Antar at det dersom det er realtivt lik sannsynlighet for de ulike utfallene
er mer effektivt å starte med den testen (if()) som bruker færrest/enklest operasjoner i betingelsen

løkker
? Dersom du skal iterere gjennom et array så lenge en betingelse er sann - fx at en verdi er mindre enn en annen
kan det være mer effektivt å bruke while() istedenfor for(), ettersom while kun tar en true/false sjekk,
mens en for-løkke alltid har 3 operasjoner

hjelpevariabel
? For å unngå hyppig indeksering (aksessering av array), en mer tidkrevende operasjon, kan du lage
en hjelpevariabel som holder indeksen/verdien, og slike redusere antall aksesseringer

hei