
* super og sub classes

# Generiske typer

## Interface
https://www.geeksforgeeks.org/java/interfaces-in-java/

* en abstrakt type som definerer en klasses *oppførsel* - "blueprint"
* inneholder static constants og abstrakte (tomme) metoder

* default: variabler er public, static og final
* bruker for abstraksjon og "multiple inheritance"
    * multiple inheritance - en klasse kan arve egenskaper fra flere "parent classes"
    * nb - problemer dersom super og sub klasser har samme signatur (parametre) - compileren vet ikke hvem du kaller
    * nb - java tillater ikke multiple inheritance av klasser, kun interfacer!
* definerer metoder som arvtakerne *må* implementere
* nb - abstract nøkkelordet brukes kun på klasser og metoder som *ikke kan instantieres direkte, men må implementeres*

* private metoder kan kun kalles i default/static metoder i interfacet, ikke i klasser som implementerer den!
* static methods er også kun tilgjengelige via interfacet, og ikke via objekter (instantiering)

### Implements vs extends
* en class extends class - utvider (super og subklasse - se under)
* en interface extends interface - utvider
* en class implements interface - kun klasse kan implementere interfaces! ikke motsatt

### Bruk av class vs interface
* class - representerer en ekte entity med attributter (variabler) og oppførsel (metoder)
    * når du skal opprette et objekt som kan holde "state" og utføre handlinger
* interface - når du definerer en "kontrakt" for oppførsel som *flere* klasser kan implementere
    * ideelt for abstraksjon og multiple inheritance

## Java arv - super- og sub-klasser
* lignende som interface, men class (child/sub) arver fra class (parent/super), og ikke fra interface
* *extends*-nøkkelordet indikerer arv fra en klasse
* for å unngå at andre kan arve fra en spesifikk klasse - bruk final-nøkkelordet "final class Vehicle {}" - klassen kan da *ikke* extendes
* veldig nyttig for gjenbruk av attributter og metoder, men! det kan også overforbrukes
* se også: Polymorphism - når mange klasser "er i slekt" via arv fra felles "forelder"

# Notater fra læreboka
## 1.4.2
En generisk egenskap er en egenskap som er felles for alle individene innen samme art.
I programmering brukes begrepet generisk både om metoder og klasser.
alle datatyper som er «sammenlignbare» (dvs. at instanser kan sammenlignes innbyrdes og ordnes i en bestemt rekkefølge) utgjør samme «art».
* int og double (primitive) - sammenlignes mhp størrelse. Sammenlignes vha. ulikhetstegnene (<, <=, >, >=)
* String (referansetype) - sammenlignes mhp alfabetisk orden. Sammenlignes med metode .compareTo() for String
* -> Derfor er det ikke mulig å lage en felles maks-metode for alle «sammenlignbare» typer.
Men vi kan få det til for alle referansetyper T som er «comparable», dvs. er en subtype til grensesnittet Comparable<T>.

Java tillater å kalle ulike metoder ved samme navn, dersom de tar inn ulike signaturer (type/antall/rekkefølge på parametre)
Derfor kan de ulike maksmetodene hete det samme, og kompilatoren vil avgjøre
hvilken metode som kjører basert på datatypen/parametrene
-> Derfor kan vi kalle det en generisk metode, selv om det egt er 3 ulike metoder
(nb i C++ vil det gjøres på en annen måte - temlate og operator overLoading)
