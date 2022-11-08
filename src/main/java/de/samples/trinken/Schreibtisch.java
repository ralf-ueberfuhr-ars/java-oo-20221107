package de.samples.trinken;

public class Schreibtisch {

    String farbe;
    int breite;
    int höhe;

    void streichen(String neueFarbe) {
        farbe = neueFarbe;
    }

    void absenken(int differenz) {
        höhe = höhe - differenz;
    }

}
