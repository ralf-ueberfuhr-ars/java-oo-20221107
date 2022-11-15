package de.samples.firma.daten;

public class KontoNichtGedecktException extends Exception {

    private final Konto konto;
    private final double betrag;

    public KontoNichtGedecktException(Konto konto, double betrag) {
        this.konto = konto;
        this.betrag = betrag;
    }

    public double getBetrag() {
        return betrag;
    }

    public Konto getKonto() {
        return konto;
    }
}
