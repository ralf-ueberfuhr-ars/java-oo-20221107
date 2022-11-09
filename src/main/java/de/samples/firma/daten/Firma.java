package de.samples.firma.daten;

public class Firma {

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

    // gehaltZahlen für alle
    public void gehaltZahlen() {
        for (Mitarbeiter ma : this.mitarbeiter) {
            if (null != ma) {
                this.gehaltZahlen(ma);
            }
        }
    }

    // gehaltZahlen für einen
    public void gehaltZahlen(Mitarbeiter mitarbeiter) {
        this.konto.überweisen(mitarbeiter.getKonto(), mitarbeiter.getGehalt());
    }

}
