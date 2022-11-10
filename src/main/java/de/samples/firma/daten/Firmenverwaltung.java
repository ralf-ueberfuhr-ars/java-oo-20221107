package de.samples.firma.daten;

import java.util.Collection;
import java.util.HashSet;

public class Firmenverwaltung {

    // Singleton = Design Pattern

    // 1 Instanz!
    private static Firmenverwaltung theInstance;

    private final Collection<Firma> firmen = new HashSet<>();

    private Firmenverwaltung() {

    }

    public static synchronized Firmenverwaltung getTheInstance() {
        if(null == theInstance) {
            theInstance = new Firmenverwaltung();
        }
        return theInstance;
    }


    public Collection<Firma> getFirmen() {
        return firmen;
    }

    public void register(Firma firma) {
        firmen.add(firma);
    }



}
