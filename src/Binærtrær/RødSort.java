package Binærtrær;
// https://www.youtube.com/watch?v=yiM8VlIJwms&list=TLPQMTIxMTIwMjWzLGqajkUnqg&index=8
// Rotasjon kompleksitet O(1) - samme antall operasjoner i en rotasjon uansett antall elementer
// PSEUDO KODE
/*
    venstreRoter (T, x) {
        y = x.right // sett y - xs høyrebarn
        x.right = y.left // sett xs høyrbarn til å peke på ys vensstrebarn

        if (y.left != T.nil) { // dersom ys venstre ikke er en nil-node?
            y.left.p = x; // y's venstrebarns foreldrenode settes til x
        }
        y.p = x.p; // sett ys foreldrenode til å være xs foreldrenode
        if (x.p == T.nil) { // dersom xs forelder er en nil.node
            T.root = y; // set y til å være roten
        } else if (x == x.p.left) { // x er sin egen forelders venstrebarn
            x.p.left = y; // forelders venstrebarn blir nå y  istedenfor
        } else {
            x.p.right = y; // x var høyrebarnet, men nå erstattes den av y
        }
        y.left = x; // x er ys venstrebarn
        x.p = y; // y er xs forelder - vi kobler både y til x og x til y
    }

 */

import java.awt.*;

// NODEKLASSE - for hver node
class Node {
    int data;
    // i rødsorte har hver node en forelder-peker - effektiviserer innlegging/fjerning/rotasjon
    Node left, right, parent;
    Color color;

    // konstruktør
    public Node(int data) {
        this.data = data;
        this.color = Color.RED; // fordi nyinnsatte noder er røde
        this.left = this.right = this.parent = null; // hvorfor?
    }
}

// RØDSORT TRE KLASSE
public class RødSort {
    private Node root;
    private final Node NIL; // tom node, alltid sort
    // vi "erstatter" bladnoder med NIL - vi slipper å ha nullPointer-sjekk
    // hele treet har teknisk sett 1 felles NIL-node

    // konstruktør
    public Rødsort() {
        NIL = new Node(0); // har "ingen" verdi
        NIL.color = Color.BLACK;
        root = NIL; // ingen noder enda - rot er NIL
    }

    // VENSTREROTASJON - tar inn X
    private void venstreRoter(Node x) { // x = roten i subtreet
        Node y = x.right; // tmp Y - peker på Xs høyrebarn
        x.right = y.left; // Ys venstrebarn blir Xs høyrebarn - bytter om og beholde BST struktur
        if(y.left != NIL) { // så lenge Ys venstre ikke er NIL
            y.left.parent = x; // oppdater foreldrenoden til å være X
        }
        y.parent = x.parent; // Xs forelder blir Ys forelder
        if (x.parent == NIL) { // dersom X er rotnoden (den har ingen forelder)
            root = y; // y blir den nye roten
        } else if (x == x.parent.left) { // ellers - X er et venstrebarn
            x.parent.left = y; // sett Y til å være venstrebarn
        } else { // ellers - X er et høyrebarn
            x.parent.right = y; // sett Y til å være høyrebarnet (erstatt X)
        }
        y.left = x; // sett X til Ys venstrebarn
        x.parent = y; // koble X til Y (foreldrenode
    }

    // HØYREROTASJON - tar inn Y, og .right blir .left
    private void høyreRotasjon (Node y) {
        Node x = y.left; // X er Ys venstrebarn
        y.left = x.right; // Xs høyrebarn blir Ys venstrebarn
        if (x.right != NIL) { // dersom Xs høyre ikke er NIL
            x.right.parent = y; // oppdater foreldrenoden til Y
        }
        x.parent = y.parent; // sett Xs foreldrenode til å være Ys forelder
        if (y.parent == NIL) { // om Ys forelder er NIL er den roten
            root = x; // sett X til å være rot
        } else if (y == y.parent.right) { // dersom Y er høyrebarn
            y.parent.right = x; // endre det til X
        } else { // dersom Y er venstrebarn
            y.parent.left = x; // bytt venstrebarnet til X
        }
        x.right = y; // sett Y til Xs høyrebarn
        y.parent = x; // X blir Ys foreldrenode
    }
}
