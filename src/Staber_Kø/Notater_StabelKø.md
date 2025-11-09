# Stabler og køer

## Stabel - LIFO - (stack)
* Last in, First Out - som en stabel med tallerkener, der man både legger inn og tar ut fra toppen av stabelen
* Java har en egen Stack man kan implementere, men denne er ikke god, så det er bedre å lage en selv

**Terminologi**
* push -legg inn i stabelen (øverst/bakerst)
* pop - tar ut av stabelen (øverst/bakerst)
* pekk - kikk på det øverste/bakerste elementet (det du hadde tatt ut med pop)
* 

## Kø - FIFO - (queue)
* First In, First Out - som en kø, der den første i køen også er den første som behandles
* Kø kan implementeres relativt enkelt med dobbeltlenketliste
  * vi legger inn ved halepekeren, og tar ut ved hodepekeren - det gir best effektivitet
  * dersom vi tar ut ved hale må to pekere bytte plass, og halepekeren "hoppe bakover" i lista, mens den foregåående setter til å peke på null
* Det er også mulig å implementere med ArrayList
  * 

**Terminologi**
* enqueue - legg inn (bakerst)
* dequeue - ta ut (forrest)
* peek - kikk på forrerste element

### Prioritetskø (priority queue)
* Vi legger elementer inn med en prioritet, og elementene sorters og hentes ut basert på denne
* Høy prioritering, lavt tall, lav prioritering, høyt tall

### Dequeue ("Deck")
