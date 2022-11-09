package de.samples.firma.daten;

public class Firma {

    private String name;
    private Ort ort;
    private Konto konto;
    // {null, null, null, null, ...., null}
    private Mitarbeiter[] mitarbeiter;

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
    public void entlassen(Mitarbeiter ma) {
        for (int i = 0; i < mitarbeiter.length; i++) {
            if (mitarbeiter[i] == ma) {
                mitarbeiter[i] = null;
                break;
            }
        }
    }

    // gehaltZahlen
    public void gehaltZahlen() {
        for (Mitarbeiter ma : this.mitarbeiter) {
            if (null != ma) {
                this.konto.überweisen(ma.getKonto(), ma.getGehalt());
            }
        }
    }

}
