package de.samples.trinken;

@Geräusch
public class Kommode extends Möbelstück {

    int anzahlSchieber;

    @Override
    void absenken(int differenz) {
        // Ersetzen der Implementierung der Oberklasse
        höhe = höhe -differenz / 2;
    }

}
