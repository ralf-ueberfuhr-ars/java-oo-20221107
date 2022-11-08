package de.samples.firma.daten;

public class Mitarbeiter {

    private String name;
    private int alter;
    private double gehalt;
    private Konto konto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public double getGehalt() {
        return gehalt;
    }

    public void setGehalt(double gehalt) {
        this.gehalt = gehalt;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

    public boolean heißtWie(Mitarbeiter ma) {
//        if(ma != null && this.name != null) {
//            return this.name.equals(ma.name);
//        } else {
//            return false;
//        }
        return ma != null && this.name != null
          && this.name.equals(ma.name);
    }

}
