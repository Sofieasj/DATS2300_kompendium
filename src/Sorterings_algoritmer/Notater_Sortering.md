# Sorteringsalgoritmer
Sortering er essensielt for å forenkle komplekse problemer og foredre effektiviteten.

* Brukes mye i søk, databaser, divide- and conquer-strategier, datastrukturer
  * Organisere store datasett -> enklere håndtering og printing
  * Rask tilgang til n-te minste eller største element
  * Muliggjør binærsøk

*Ulike sorteringer*
* In-place-sorting
* Internal/external sorting
* Stabil sortering
* Ustabil sortering
* Hybrid sorteringsalgoritme
* Sammenligninsbasert sortering
* Ikke-sammenligningsbasert sortering

| Stabil sortering | Ustabil sortering |
|:-----------------|:-----------------:|
| Bubble sort      |  Selection sort   |
| Insertion sort   |    Quick sort     |
| Merge sort       |     Heap sort     |

m## Selection sort
O(n^2) - uavhengig av case - hele arrayet må gjennomsøkes for å finne minste verdi
i denne implementasjonen: sorter har en loop, og inni denne
kalles min() som også har en loop -> nestede loops

vi går gjennom arrayet igjen og igjen (n ganger), finner og flytter den
laveste verdien til rett før den usorterte delen av arrayet begynner
vi gjentar inntil arrayet er sortert
vi sorterer en og en verdi

## Insertion sort
avg O(n^2) pga nestede for-loops
best cas O(n), alt sortert listem worst case O(n^2), sortert synende

vi starter med å anta at første verdi i arrayet er sortert
vi ser på neste verdi og ser om det er en inversjon mellom denne og den foregående
dersom det er det bytter vi plass
derett går vi til neste indeks - vi ser på det er en inversjon ml. denne og den foregående
dersom det er det, bytter vi, og så sjekker vi for inversjon ml denne og den (eller de) foregående elementene
vi repeterer dette inntil vi har vært gjennom hvert element og vet at det er rett plassert
fordi vi antar at første verdi er sortert trenger vi ikke sortere denne - altså kjører vi gjennom arrayet n-1 ganger

## Bubble sort
avg O(n^2) - pga to nestede forløkker
best case (pga. break) er O(n) - vi går gjennom alt 1 gang og ser at verdiene er sortert

vi sorterer arrayet fra laveste til høyeste verdi ved å "boble"
høyere verdier oppover i arrayet, hver gang vi finner en inversjon

vi bruke loop og går gjennom arrayet, en verdi om gangen
for hver verdi ssammenligner vi med neste verdi (inversjon)
dersom det er en inversjon, bytter vi verdiene
vi iterer n ganger gjennom arrayet

## Merge sort
Alltid O(n log n) - uavhengig av best/worst/avg case - fordi vi deler opp alt, sorterer og så fletter sammen igjen
halveringen er O(log n) og sammenflettingen er O(n) -> O(n log n), litt verre enn O(n), men bedre enn O(n^2)

vi halverer arrayet gjentatte ganger inntil hvert array er kun 1 element langt
så fletter vi rekursivt sammen igjen, nivå for nivå, og sorterer hvert nivå som flettes

vi har en int[] metode som tar inn et array
en basecase - om det er 1 eller færre elementer i arrayet
finner lengden og oppretter et v og et h array med halve lengden hver
via for loop legges verdiene i []a inn i disse (en halvdel i hver)
vi setter v og h til å være mergesort(v) og mergesort(h) - altså rekursive kall - disse vil repetere inntil base case
deretter kalles merge-funksjonen, via return, som sorterer og fletter sammen igjen arrayet

merge tar inn v og h []
lager et resultatarray med lengde v+h, og indekstellere for alle arrayene til bruk i while-løkker
først - while det er elementer i v og h - sammenligner med if og legger den minste av de to inn i resultat-array
dersom ett array er tomt legges de resterende fra det andre inn i resultat, som så returneres

## Quick sort
