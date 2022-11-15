package de.samples.firma.daten;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class Firma implements Iterable<Mitarbeiter> {

    // Konstante = Klassenvariable (unveränderlich)
    public static final int STANDARD_ANZAHL = 100;
    private String name = "";
    private Ort ort;
    private Konto konto;
    // {null, null, null, null, ...., null}
    private final Mitarbeiter[] mitarbeiter;

    public Firma() {
        this(Firma.STANDARD_ANZAHL);
    }

    public Firma(int maximaleAnzahlMitarbeiter) {
        mitarbeiter = new Mitarbeiter[maximaleAnzahlMitarbeiter];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ort getOrt() {
        return ort;
    }

    public void setOrt(Ort ort) {
        this.ort = ort;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

    // einstellen
    public void einstellen(Mitarbeiter ma) {
        // TODO ist er schon drin?
        for (int i = 0; i < mitarbeiter.length; i++) {
            if (mitarbeiter[i] == null) {
                mitarbeiter[i] = ma;
                break;
            }
        }
    }

    // entlassen
    public void entlassen(final Mitarbeiter ma) {
        for (int i = 0; i < mitarbeiter.length; i++) {
            if (mitarbeiter[i] == ma) {
                mitarbeiter[i] = null;
                break;
            }
        }
    }

    public Mitarbeiter findeNachNamen(String name) {
        for (int i = 0; i < mitarbeiter.length; i++) {
            if (name.equals(mitarbeiter[i].getName())) {
                return mitarbeiter[i];
            }
        }
        return null;
    }

    public Optional<Mitarbeiter> findeNachNamenMitOptional(String name) {
        return Stream.of(this.mitarbeiter)
          .filter(m -> m.getName().equals(name))
          .findFirst();
    }

        // Reiche Mitarbeiter = MA mit 100k EUR auf dem Konto
    public Stream<Mitarbeiter> getReicheMitarbeiter() {
        return Stream.of(this.mitarbeiter)
          .filter(m -> m.getKonto() != null && m.getKonto().getStand() >= 100_000);
    }

    // gehaltZahlen für alle
    public void gehaltZahlen() {
        Stream.of(this.mitarbeiter)
          .filter(Objects::nonNull)
          .forEach(this::gehaltZahlen);
/*
        for (Mitarbeiter ma : this.mitarbeiter) {
            if (null != ma) {
                this.gehaltZahlen(ma);
            }
        }
*/
    }

    // gehaltZahlen für einen
    public void gehaltZahlen(Mitarbeiter mitarbeiter) {
        this.konto.überweisen(mitarbeiter.getKonto(), mitarbeiter.getGehalt());
    }

    @Override
    public Iterator<Mitarbeiter> iterator() {
        return Arrays.asList(mitarbeiter).iterator();
    }
}
