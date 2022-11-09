package de.samples.firma.daten;

public class Ort {

    /*
     * immutable: nicht veränderlich
     *  - wenn sich der Name ändert --> neues Objekt / neue Referenz
     *  + Objekt ist direkt nach Konstruktoraufruf konsistent (1 Zeile)
     *  + Validierung, Konvertierung nur einmalig (Performance)
     *  + Caching
     *  + Thread-Safety (s. Konto#überweisen)
     *    - konto1 (1000 EUR)
     *     - T1: konto1.überweisen(200, konto2)
     *     - T2: konto1.überweisen(300, konto3)
     *     - Ablauf:
     *       - T1: konto1.stand = 1000
     *       - T2: konto1.stand = 1000
     *       - T1: 1000 - 200 = 800
     *       - T2: 1000 - 300 = 700
     *       - T1: 800 --> konto1.stand
     *       - T2: 700 --> konto1.stand
     *       => konto1: 700 EUR
     */

    private final String name;
    private final String postleitzahl;

    public Ort(String name, String postleitzahl) {
        // Konvertierung, Validierung
        this.name = name;
        this.postleitzahl = postleitzahl;
    }

    public String getName() {
        return name;
    }

    public String getPostleitzahl() {
        return postleitzahl;
    }

}
