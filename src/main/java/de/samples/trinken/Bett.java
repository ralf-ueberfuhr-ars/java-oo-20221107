package de.samples.trinken;

@Geräusch("quietsch")
public class Bett extends Möbelstück {
    @Override
    public void zeigeInhalt() {
        System.out.println("Liegt einer drin!");
    }
}
