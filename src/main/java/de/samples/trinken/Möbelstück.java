package de.samples.trinken;

public abstract class Möbelstück implements Höhenverstellbar {

    Möbelfarbe farbe;
    int breite;
    int höhe;

    void streichen(Möbelfarbe neueFarbe) {
        farbe = neueFarbe;
    }

    @Override
    public void absenken(int differenz) {
        höhe = höhe - differenz;
    }

    public abstract void zeigeInhalt();
}
