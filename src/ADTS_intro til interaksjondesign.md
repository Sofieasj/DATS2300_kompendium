# Intro til interaksjonsdesign

## Interaksjon
* to eller flere ting eller personer kommuniserer med/reagerer på hverandre
* interaksjon ml. bruker og system - en del av UX
* både UI (grensesnitt, visuelt) og UX (brukeropplevelse)
* typer: 
  * instruerende - brukeren kommanderer/velger ml. flere alternativer - skru på tv med fjernkontroll
  * konverserende - brukeren snakker med system som dialogpartner - fx chatgpt
  * manipulerende - 
  * utfordkrende - bruker oppdager info via navigasjon - fx AR
* mentale modeller! veldig viktig. hva brukeren tror om et system, fører til forventning og prediksjon -> påvirker hvordan brukeren bruke systemet
  * basert på bakgrunn, kunnskap og tidl. erfaringer -> bruker systemet veldig ulikt, kan ikke forutse hvordan de vil bruke systemet
  * ofte stort gap ml. designeres og brukeres mentale modeller
  * representert modell (UI) må være en miks av implementasjonsmodell (teknologi) og brukeres mentale modell
    * vi bruker datainnsamling for å lære om og forstå deres mentale modeller
* kognitiv belastning - hjernen har begrenset prosesseringsevne, vi vil ikke at vår side skal være for kognitivt belastende å bruke
  * bruk designheuristikker, designprinsipper og retningslinjer + datainnsamling (grunnlag)
* Don Norman - forsker og professor innen design, kognitiv vitenskap og ingeniørfag - coined "UX", the design of everyday things
  * Normans designprinsipper: (kan minne om Nielsens heuristics som er tema i eksamen)
  * Visibility - brukeren skal lett kunne oppfatte systemets status og handligner
  * Feedback - gi klare og umiddelbare tilbakemeldinger på brukerens adferd
  * Affordance - design bør antyd/si hvordan det skal brues
  * Mapping - bruk logisk sammenheng ml. hvordan noe ser ut og funker
  * Constraint - begrens brukernes handlinger for å redusere feil
  * Conssitency - konsekvent design, fremme gjenkjennelse

## Designelementer - et utvalg
* ulike elementer har ulike navn, og det er best practices på hvordan de bør brues
* ikoner - visuelle representasjoner av handling/objekkt/ide - kommuniserer en mening
  * burde stå sammen med tekst
  * universelle ikoner trenger ikke det - fx søkeikon (forstørrelsesglass)
  * skal være forståelig for alle! test om brukere forstår ikonene, særlig ikke-univserselle
  * ikke gi etablerte ikoner en ny mening - fx bruke søkeikonet for noe helt annet
* Knapper 
  * primærknapp - fylt inn med farge, den viktigste handlingen på siden og skal ta med oppmerksomhet
  * sekundærknapp - kant, men ikke fylt inn, mindre viktig handling, skal ta noe oppmerksomhet
  * tertiærknapp - uten linje fx, skal ta minst oppmerksomhet
  * hover - effekt når man drar musen over knappen - feedback til brukeren, dette kan klikkes på
    * også: diasblede/gråede ut knapper som ikke kan trykkes på
  * fokusk - tastaturbruk
* Radioknapper - velg kun 1 alternativ, og 1 må velges
  * plasser vertikalt, ikke horisontalt
  * sirkel OG tekst bør være klikkbar - lettere å treffe for brukeren
* sjekkbokser - flervalg, eller ingen valgt
  * kan ha hjelpetekst, fx om man må velge et visst antall
  * kan også være noe man sjekke/ikke sjekker - som å akseptere betingelser
* toggle switch - binær handlinger som å slå av/på, light mode/dark mode
  * alltid en standardinnstilling, og gir et umiddelbart resultat
  * nb - sier egt ikke hva som skjer når man toggler (bruker fx farge for å kommunisree av/på)
    * best practice er egt å også ha med tekst! "av"/"på"
* input felt - fylle inn tekst/tall
  * kan være klikkbare
  * labels - navnet på feltet over feltet
  * placeholder tekst for å hjelpe brukeren forstå hva + formatet på det som skal fylles inn
* Dropdown - velge mellom mange alternativer (typisk mer enn 6 alternativer)
  * trykk på boksen og få opp valgene
  * best practice - la brukeren skrive inn og få forslag
    * fx skrive NOrg og så få foreslått Norge, istedenfor å scrolle helt ned

# Eksempler på godt og dårlig design
* fra The design og everyday things og andre digitale eksempler
* noen dørhåndtak forteller visuelt at det bør dras i (det har et egnet  håndtak), men det står et skilt om push - designet burde heller si noe om hvordan det skal brukes
  * et godt design her ville ikke trenge skilt, fordi utformingen forteller oss hva vi skal (affordance)
* Mange skilt oppo hverandre om parkeringsregler - vanskelig å forstå, kognitiv belastning, frustrerende og kan føre til forvirring -> feil -> borttauing
* Hvilken bryter tilhører hvilken kokeplate? Designet forteller ikke dette, må ha hjelpetekst - ikke ideelt
  * sammenheng med mapping - god sammenheng ml visuelt og faktisk
* Overveldende kompleksitet - fx fjernkontroller med svært mange knapper hvor få brukes, og man har kanskje flere kontroller og
  * og inkonsekvent ml ulike kontroller hvor ting er plassert, om det er farger osv - mangel på standarder - consistency for gjenkjennelse (derfor også kognitiv belastning)
* se powerpoint
  * utforming av skjemaer - vi vil gjøre det så enkelt og tydelig som mulig
  * 

# Case: Oda - godt design og gode standarder
*  Det er bra å hente inspirasjon fra andres design, men ikke kopiere alt! ha din egen stil
  * ikonene har tekst - tydeliggjør hva de betyr
  * bilder sammen med kategorinavn + antall typer i en kategori - får inntrykk av hvor mye vi vil få opp
  * ligner fysisk handel - kategorisering slik man kategoriserer i fysisk butikk, legger til i handlevogn
  * søkemotor - kan legge varer til direkte fra søket - kommer opp forslag 
    * og forslag om andre varer som ofte kjøpes sammen med varen du søkte etter
  * konsekvent ikonbruk - + betyr alltid legg i handlekurv
  * hjerte - betyr alltid legg i handleliste (handleliste modellerer virkelig verden)
  * hjelpetekst - hvor mye man må handle for, for å få gratis frakt/slippe tillegg
    * også en bar som illustrerer dette - gamification (motiverer, blir et slags spill - vi vil komme i mål)
  * destruktiv handling - markert med rød tekst - tømme handlekurven (slette)
  * leveringstid - kombinerer farger og ikoner (universell utforming, kan bruke om man kan se farger fx)
  * pop up-forhåndsvisnign av vare - slipper å bytte side 
    * nb ikke bruk for mange pop ups (nestede) - mister oversikt over hvor man er og hvordan man kommer seg tilbake
  * kokeboka - alle varer tilhørende en oppskrift kan raskt legges inn i handlevogna - mengde basert på antall porsjoner man skal lage
    * mulighet for å endre varer (enkelt velge alternativ) - fx om noe er utsolgt, eller man ikke ønsker denne
    * visuelt markere når noe er utsolgt (ikke bare fjerne det)
    * kategori for basisvarer - salt, olje osv, som man generelt har, og heller opter in til å legge til i handlelista