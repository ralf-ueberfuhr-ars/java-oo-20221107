package de.samples.firma.daten;

import java.util.Objects;

public class Mitarbeiter implements Comparable<Mitarbeiter> {

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

    @Override
    public int compareTo(Mitarbeiter m) {
        // Aufpassen: this.name == null?
        // Aufpassen: gleicher Name --> Duplikat?
        // Sortierung nach Namen absteigend
        return -this.name.compareTo(m.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Mitarbeiter that = (Mitarbeiter) o;
        return alter == that.alter && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, alter);
    }

    @Override
    public String toString() {
        return "Mitarbeiter{" +
          "name='" + name + '\'' +
          ", alter=" + alter +
          ", gehalt=" + gehalt +
          '}';
    }
}
