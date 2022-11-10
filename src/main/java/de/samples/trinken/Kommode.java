package de.samples.trinken;

public class Kommode extends Möbelstück {

    int anzahlSchieber;

    void absenken(int differenz) {
        // Ersetzen der Implementierung der Oberklasse
        höhe = höhe -differenz / 2;
    }

}
