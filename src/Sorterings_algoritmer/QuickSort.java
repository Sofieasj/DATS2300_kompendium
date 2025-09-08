package Sorterings_algoritmer;

/*
    når begge pekere er på samme punkt ELLER krysser hverandre har vi vært gjenom hele arrayet - stopp
    på én iterasjon sorterer vi hele arrayet på en (1) skilleverdi
    vi bytter bare om tallene med en hjelpevariabel, og input arrayet (ikke et ekstra hjelpearray) som husker skilleverdien
    rekursjon + færre iterasjoner enn bubble sort - antall ganger som vi kan dele a = {n} på to
*/

import java.util.Arrays;

public class QuickSort {

    // quick sort av tall - oddetall til venstre, partall til høyre, i stigende rekkefølge
    // skal ikke sende feilmeldinger ved: tom tabell, negative tall, kun partall, kun oddetall

    // tom tabell - a.length == 0 -> gjør ingenting
    // kun oddetall - høyre del er tom -> sorter kun venstre del
    // kun partall - venstre del er tom -> sorter kun høyre del
    // negative tall - defineres som vanlig (x % 2 == 0 (partall) og !x % 2 == 0 (oddetall)

    // SORTER PÅ SKILLEVERDI
    public static int[] sorterSkilleverdi(int[] a) {
        int skilleverdi = a[a.length - 1]; // siste element er skilleverdi
        int v = a[0];
        int h = a.length-2;

        //loop - nb vær obs på vaktposter!
        while(v <= h) {
            // hvorfor brukes while og ikke if? fordi den skal kjøre inntil den finner en hvor det ikke er sant (?)
            while (a[v] < skilleverdi) {
                v++;
            }
            while (a[h] > skilleverdi) {
                h--;
            }
            // bytt plass - større tall til høyre, mindre til venstre
            int temp = a[v];
            a[v] = a[h];
            a[h] = temp;
            v++;
            h--;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] resultat = (sorterSkilleverdi(new int[]{1,3,5,8,7,9,4,2,6}));
        System.out.println(Arrays.toString(resultat));


    }
}
