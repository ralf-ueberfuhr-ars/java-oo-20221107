package de.samples.trinken;

public class Trinkgefaess {

    String farbe;
    int volumen = 10; // ml
    int leerGewicht;
    int gewicht;
    Möbelstück ort;

    // Rückgabetyp, Namen, Parameter, Impl.

    void ausschuetten() {
       gewicht = leerGewicht;
    }

    void fuellen(int fuellung) {
        gewicht = gewicht + fuellung;
    }


}
