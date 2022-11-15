package de.samples.firma.daten;

public class Konto {

    private double stand;
    private String nummer;

    public double getStand() {
        return stand;
    }

    public void setStand(double stand) {
        this.stand = stand;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public void überweisen(Konto ziel, double betrag) throws KontoNichtGedecktException {
        synchronized (this) {
            if(this.stand < betrag) {
                throw new KontoNichtGedecktException(this, betrag);
            }
            this.stand -= betrag;
            ziel.stand += betrag;
        }
    }

    public static void überweisen(Konto quelle, Konto ziel, double betrag) throws KontoNichtGedecktException {
            quelle.überweisen(ziel, betrag);
    }
}
