package de.samples.trinken;

@Geräusch("knarz")
public class Schreibtisch extends Möbelstück {

    @Deprecated
    int tischplattenGroesse;

    @Override
    public void zeigeInhalt() {
        System.out.println("Auf der Tischplatte...");
    }
}
