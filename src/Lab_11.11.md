# Lab: Eksamensgjennomgang kont 2024

1. Gjennomsnittskompleksitet, innlegging i binærsøketrær - O(log n)
   * antall noder dobles per nivå
   * vi legger inn i bunnen, og beveger verdien inntil rett plassering
   * gjennomsnittshøyde - log n -> O(log n)
   * verst: største antall elementer vi må gjennom for å plassere verdien korrekt - treet er ubalansert, som linkedlist = O(n)
   * dersom treet har 32 noder - log 32 = 5 - finner avg antall (5) prosesser vi må gjennom
2. Antall noder i et tre med høyde 4 - 31 noder
   * nivå 0-n, høyde n
   * antall noder = 2^h+1 -1 = 2^4+1 - 1 = 2^5 - 1 = 32-1 = 31 noder
   * på små tre kan man like godt tegne treet :)
3. Tidskompleksitet, når input øker fra 10k på 2sek til 100k, hvor lang tid tar det? 20 sek
   * går gjennom usortert liste og finner største element - finnMaks() - lineærsøk = O(n)
   * O(n) - når input dobles, dobles output - vi ganger med 10
   * (1000 på 2 sek = 5000 på 1 sek -> 100000/5000 = 20 sek)
4. Treorden, verdiene skrives ut i en gitt rekkefølge, hvilken orden er brukt? Nivåorden
   * postorden - roten printes sist - v, h, r
   * preorden - r, v, h
   * inorden - v, r, h (binærsøketrær printes sortert stigende v/inorden)
   * nivåorden - nivå pr nivå, fra venstre til høyre
5. Egenskaper til en minimumshaug? foreldrenoder er mindre enn sine barn
   * et komplett binærtre, der hver foreldrenode er mindre enn (eller lik) sine barn (gjennom hele treet - rot er det aller minste)
   * innlegging - vi legger inn i bunnen (komplett tre), så sammenligner vi oppover for å sikre at foreldrenodene er mindre enn denne
   * max heap - foreldrenoden er større enn eller lik sine barn
6. Huffman-trær og komprimering, stav ordet med binærtall - 
   * de med høyest frekvens skal ligge øverst i treet, de med lavest ligger nederst - de vi bruker ofte er raskest å nå
   * sorter verdier etter frekvens i prioritetskø
   * slå sammen de to minste nodene, oppdater prioritetskøen
   * skriv opp venstreorientert, kanonisk og legg inn verdiene - tell veier 0=v 1=h og finn binærkoden for hvert tegn
   * stav ordet med binærtallene
7. Binærsøketre, hvilket binærsøketre vil vi få når vi legger inn denne rekken tall []? 
    *
8. 
   *
9. 
   *
10. 
    *