# Forelesning 11.10 - Gjennomgang av eksamen 2022

* øvingstime i morgen - plenumsveiledning m/kahoot og eksamensgjennomgang
* Nikolai har laget eksamen siden 2023 - tidl. annen foreleser

## Om eksamen 2025
* Eksamen blir i wiseflow - i morgen får vi tilgang til 2024-eksamen i Wiseflow, så vi kan bli kjent med systemet
* europe.wiseflow.net -> logg inn med feide  via oslomet -> gå til deltagere (antagelig) og finn prøveeksamen + demo flows
* flowMulti - vår eksamenstype, bruk flowMulti avansert for å se hvordan det vil se ut

* det ligger kalkulator innebygget i eksamen - så du trenger ikke ta med selv - ligger som en knapp høyt oppe (?)

* tekstsvar - ligger link til pdf med vedlegg - åpnes i ny fane
* svar i tekstboksen under

* kodeoppgaver - ikke kodefelt i wiseflow enda, skal skrive kode i ordinær tekstboks, men det er en liten knapp for å få opp kode editor (linje nr osv)
  * nb - ingen fargelegging eller error varsling, kun tekst - men tabs og linje nr er der
* koden trenger ikke kompilere - det er viktig å forstå logikken, ikke å skrive korrekt
  * fokuser på hva koden gjør! hva som skal skje
* h3 er større enn h1 - så obs på det når man leser
* håndtegning som scannes inn - vi skal i år bare tegne og fysisk levere inn ark (som i inspera)
  * neste år skal vi selv ta bilde av håndtegningene
  * boks - kan skrive forklaring der, eller direkte på arket
  * blir en tegneoppgave på eksamen! står i oppgavebeskrivelsen at det skal tegnes
* kan ikke forsøke å gi lengre svar og forklare tankegang bak multiple choice

## Eksamen 2022 - gjennomgang
### Multiple choice
1. kompleksitet til indeksering (finne element på gitt indeks) i arrayList - O(1)
  * indeksering i lenketliste - avhenger av hva du ser etter, vi må gjennom hvert element inntil rett posisjon, worst case O(n)
  * arraylist, som tabell, vi går direkte til plasseringen O(1) -> mer effektivt enn linkedlist 
  * "vi har en tabell m/50 elementer (0-49). Som person, skal finne element på plass 13 -> vi må telle oss fram til 13. En maskin kan aksessere arraylokasjon og så plusser på 13 for å hoppe rett til plasseringen"
2. hvilket intervall har for-løkken () og [] - [3, 10] - kommer ikke på eksamen i år
3. høyden til et binærtre med 192 noder
  * høyde = antall nivå-1 (eller nr til nederste nivå - nivå starter på 0 (rot)) - også, hvor langt det er fra topp til bunn, antall grener ml noder nedover
    * ett nivå mer enn høyden - h=n-1
  * høyde må være et heltall, og et oddetall fordi roten er kun 1 node
  * antall noder = 2^h+1 - 1
  * høyde = vil at 2^h+1 -1 skal være 255 - vi regner ut likningen og finner hva h må være
    * kan telle på fingrene = 2^h+1-1 = 255, 2^h+1 = 256 = h = 7
    * vi vet at perfekte trær har en mindre enn potens av 2 - hvor ville vi ha plass til alle (nederste nivå trenger ikke være fullt)
4. i hvilken rekkefølge vil den rekursive koden printe ut verdiene i treet? inorden -> sortert stigende
    * vi gjenkjenner hvilken orden som brukes, og finner ut hvordan det ville printes ut
5. Huffmantre - lag kanonisk, venstreorientert tre og komprimer meldingen (binærtall). Velg rett alternativ
   * skriv verdiene stigende - prioritetskø
   * slå de minste verdiene sammen, plasser foreldrenode på rett plass i prioritetskø
   * slå sammen de minste... osv osv
   * tegn opp venstreorienter kanonisk tre
   * tell opp hvilket binærtall hvert tegn før
   * skriv ordet og velg rett alternativ
6. Dijkstra - hvilken rekkefølge besøkes nodene i (prioritetskø) -  BADCEGFH
   * se utregning på ark
7. Minimumshaug - hvor vil tallet 4 legges inn?
    * regle for innlegging - legg inn på neste ledige plass (komplett tre), så legg mest mulig mot venstre i nederste nivå
    * dytt verdien oppover inntil den er rett plassert - sammenlign med foreldre, dersom den er mindre bytter vi plass på verdiene (repeter til forlder er mindre enn vår node)
8. Min heap - fjern et tall (implisitt - fjern det minste tallet), hvordan ser treet ut nå? 
   * regel for fjerning - vi tar ut minste verdi = rot
   * må fremdeles være et lovlig (komplett tre) - bytt plass på 5 og siste node
   * men nå er det feil rotverdi - den må boble nedover ved å bytte plass med den minste av side barn, repeter
9. Kodeforståelse - forstå hva koden faktisk gjør når variabelnavnene ikke er intuitive - bytt() funksjon
   * vil ikke komme på eksamen - er for lett
Kodeforståelse, hva skjer i koden? FLytter største element bakerst ved å iterer og fjerne inversjoner (bytt())
    * kun en for-loop - derfor ikke boblesortering - men maksMetode() (linearsearch)
    * litt mer relevant for emnet, kan komme på eksamen

### Teksoppgave
* Disse oppgavene var for stor for eksamenen
* rekker ikk gå gjennom - blir pseudokode
10. Søking i stack - se på denne selv
    * stack - vi legger inn og henter ut bakerst, derfor er indeks 0 den "bakerste" indeksen
    * nb - vi må fjerne pannekaker for å finne den vi leter etter, og klare å legge dem tilbake etterpå
    * vi må derfor flytte disse (lagre dem et annet sted) - sikre at vi legger tilbake i samme rekkefølge
    * vi kan legge over i ny, midlertidig stabel (kommer i motsatt rekkefølge), og så legger vi tilbake i den originale rekkefølgen (fordi vi starter på toppen, og disse blir liggende underst av de flyttede)
    * stack midl = new Stack<>(); 
    * while (!s.empty()) T tmp = s.pop();
    * if (tmp = val) svar = n!break; // vi har funnet rett verdi og kan slutte å flytte elementer til midl
    * midl.push(tmp);
    * SE TEGNING
    * det viktige er å skjønne at vi trenger en ekstra, midlertidig stack å flytte over i, og så tilbake fra
11. QuickSort som repeterer verdier - effektiviser den for tabeller med repliserte verdier + forklar hvorfor standard er ineffektiv
    * alle elementer har samme verdi - vi sorterer kun 1 element pr iterasjon - O(n^2)
12. Implementer en versjon av quicksort som fungerer bedre på repeterte verdier
    * rotete kode er ok, så lenge ideen er der
    * funskjonen er riktig, men skille på om det er "r", "h" eller "b", litt som partall/oddetall, men vi skal omgjøre den til å sortere int etter str istedenfor char etter r, h, b
    * kikk på denne

### Tegneoppgave
13. 