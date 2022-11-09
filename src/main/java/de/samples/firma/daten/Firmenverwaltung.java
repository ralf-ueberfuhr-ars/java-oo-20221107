package de.samples.firma.daten;

public class Firmenverwaltung {

    // Singleton = Design Pattern

    // 1 Instanz!
    private static Firmenverwaltung theInstance;

    private Firmenverwaltung() {

    }

    public static synchronized Firmenverwaltung getTheInstance() {
        if(null == theInstance) {
            theInstance = new Firmenverwaltung();
        }
        return theInstance;
    }


    // Objekt
    private Firma[] firmen;
    public Firma[] getFirmen() {
        return firmen;
    }

    public void setFirmen(Firma[] firmen) {
        this.firmen = firmen;
    }


}
