# Binærtrær og binærsøk
* strukturelt og terminologisk inspirert av slektstrær - men snudd på hodet, med roten øverst

## Terminologi
* Rotnode - det øverste leddet, har ingen foreldrenode
* Foreldre - en node som har barn (noder knyttet til seg nedover)
* Barn - en node knyttet til en forelder
* Venstre-barn - noden til venstre for en forelder
* Høyre-barn - noden til høyre for en forelder
  * Vi kaller det fremdeles venstre/høyre barn også når foreldrenoden kun har ett barn - det er plass til å legge inn den andre
* Bladnode - en node uten barn
* Indre node - noder med barn (inkl. roten)
* Nivå - rot starter på nivå 0 og så teller vi oss nedover pr "generasjon"
* Høyde - tilsvarer nivået på det laveste nivået 
  * Dvs. et tre med 4 nivåer (0, 1, 2, 3) har en høyde på 3

![img_7.png](img_7.png)

```mermaid
    flowchart TD
        Rot((rotnode))
        Node1((barn
        til rot))
        Node2((forelder))
        Node3((blad))
        Node4((blad))
        Node5((barn))
        Node6((barn))
        
        Rot-->Node1
        Rot-->Node2
        Node1-->Node3
        Node1-->Node4
        Node2-->Node5
        Node2-->Node6
```

## Binærtrær


### Perfekt tre
* Alle nivåene i treet er fylte
![img_2.png](img_2.png)

### Komplett tre
* Alle nivåer untatt det siste er helt fulle, og det siste er fylt fra venstre
![img_6.png](img_6.png)

### Fullt tre
* Alle nodene har enten 0 eller 2 barn (ingen har kun 1 barn)
![img_4.png](img_4.png)

### Degenerate/skewed tree
* Hver indre node har kun ett barn - blir tilnærmet som en LinkedList og vi mister effektiviteten i binærtreet
![img_5.png](img_5.png)

## Binærsøketrær
![img_3.png](img_3.png)

### Kilder
Bilder: https://www.geeksforgeeks.org/dsa/types-of-binary-tree/


