package de.samples.firma.start;

import de.samples.firma.daten.ImmutableMitarbeiter;
import de.samples.firma.daten.Mitarbeiter;

import java.util.Collection;
import java.util.HashSet;

public class FirmenPerformanceProgramm {

    public static void main(String[] args) {
        // Equals / hashCode
        {
            Collection<Mitarbeiter> mitarbeiter = new HashSet<>();
            Mitarbeiter m = new Mitarbeiter();
            m.setName("Tom");
            m.setAlter(30);
            mitarbeiter.add(m);
            System.out.println(mitarbeiter);
            mitarbeiter.add(m);
            System.out.println(mitarbeiter);
            mitarbeiter.remove(m);
            m.setAlter(31);
            mitarbeiter.add(m);
            System.out.println(mitarbeiter);
            // --> wenn Object im HashSet, darf sich der HashCode nicht ändern
            // --> Immutability
        }

        final var schleifen = 10_000_000;
        // Performance
        {
            // performant
            Collection<ImmutableMitarbeiter> mitarbeiter = new HashSet<>();
            long t1 = System.currentTimeMillis();
            for (int i = 0; i < schleifen; i++) {
                mitarbeiter.add(new ImmutableMitarbeiter("Tom", i));
            }
            long t2 = System.currentTimeMillis();
            System.out.println((t2 - t1) + "ms");
        }
        {
            // performant
            Collection<Mitarbeiter> mitarbeiter = new HashSet<>();
            long t1 = System.currentTimeMillis();
            for (int i = 0; i < schleifen; i++) {
                Mitarbeiter m = new Mitarbeiter();
                m.setAlter(i);
                m.setName("Tom");
                mitarbeiter.add(m);
            }
            long t2 = System.currentTimeMillis();
            System.out.println((t2 - t1) + "ms");
        }
        {
            // inperformant
            Collection<Mitarbeiter> mitarbeiter = new HashSet<>();
            long t1 = System.currentTimeMillis();
            for (int i = 0; i < schleifen; i++) {
                Mitarbeiter m = new Mitarbeiter() {
                    @Override
                    public int hashCode() {
                        return 1;
                    }
                };
                m.setAlter(i);
                m.setName("Tom");
                mitarbeiter.add(m);
            }
            long t2 = System.currentTimeMillis();
            System.out.println((t2 - t1) + "ms");
        }

    }

}
