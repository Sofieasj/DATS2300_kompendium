# Rødsorte trær
Et selvbalanserende binærsøketre. 
Det er ekvivalent med 2-3-4-trær mht. balansering, men altså et ekte binærtre.

2-3-4-trær er litt krevende å programmere fordi vi må oppfylle en rekke krav, særlig fjerning er litt utfordrende.


**Regler:**
* Hver node er enten rød eller sort
* Rotnoden er sort - dette er standard
* NIL-noder er bladnoder med nullverdi (avbildes ofte ikke), de er alltid sorte
* En rød node kan aldri ha røde barn
* Fra rot til bladnode skal det alltid være samme antall sorte noder
  * Vi kan derfor snakke om "sort høyde"
  * Ettersom det aldri kan være 2 rød på rad, er hver vei fra rot til blad maks dobblet så lang som kortest vei 