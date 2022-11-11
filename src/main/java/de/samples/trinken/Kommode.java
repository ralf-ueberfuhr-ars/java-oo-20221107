package de.samples.trinken;

@Geräusch
public class Kommode extends Möbelstück {

    int anzahlSchieber;

    @Override
    public void absenken(int differenz) {
        // Ersetzen der Implementierung der Oberklasse
        höhe = höhe -differenz / 2;
    }

    @Override
    public void zeigeInhalt() {
        System.out.println("In den Schiebern...");
    }

}
