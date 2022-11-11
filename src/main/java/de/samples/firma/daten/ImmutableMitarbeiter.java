package de.samples.firma.daten;

import java.util.Objects;

public class ImmutableMitarbeiter {

    private final String name;
    private final int alter;
    private final int hash;

    public ImmutableMitarbeiter(String name, int alter) {
        this.name = name;
        this.alter = alter;
        this.hash = Objects.hash(name, alter);
    }

    public String getName() {
        return name;
    }

    public int getAlter() {
        return alter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ImmutableMitarbeiter that = (ImmutableMitarbeiter) o;
        return alter == that.alter && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return this.hash;
    }

    @Override
    public String toString() {
        return "ImmutableMitarbeiter{" +
          "name='" + name + '\'' +
          ", alter=" + alter +
          '}';
    }
}
