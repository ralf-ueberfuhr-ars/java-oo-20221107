package de.samples.trinken;

public abstract class Möbelstück {

    Möbelfarbe farbe;
    int breite;
    int höhe;

    void streichen(Möbelfarbe neueFarbe) {
        farbe = neueFarbe;
    }

    void absenken(int differenz) {
        höhe = höhe - differenz;
    }

}
