package de.samples.firma.start;

import de.samples.firma.daten.Firma;
import de.samples.firma.daten.Firmenverwaltung;
import de.samples.firma.daten.Konto;
import de.samples.firma.daten.KontoNichtGedecktException;
import de.samples.firma.daten.Mitarbeiter;
import de.samples.firma.daten.Ort;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FirmaProgramm {

    public static void main(String[] args) {

        // v und v2 müssen auf dasselbe Objekt zeigen
        Firmenverwaltung v = Firmenverwaltung.getTheInstance();
        Firmenverwaltung v2 = Firmenverwaltung.getTheInstance();

        Ort java = new Ort("JavaStadt", "12345");

        // java = null; nicht erlaubt, weil final

        Konto firmenKonto = new Konto();
        firmenKonto.setNummer("123456789");
        firmenKonto.setStand(1_234_567.89);

        Konto maKonto = new Konto();
        maKonto.setNummer("987654321");
        maKonto.setStand(1234.56);

        Mitarbeiter tom = new Mitarbeiter();
        System.out.println(tom.getName());
        tom.setName(null);
        if (tom.getName() != null) {
            // ...
            System.out.println(tom.getName().toLowerCase());
        }
        tom.setName("Tom");
        tom.setAlter(46);
        tom.setKonto(maKonto);
        tom.setGehalt(2900.00);

        Mitarbeiter julia = new Mitarbeiter();
        julia.setName("Julia");
        julia.setAlter(35);
        julia.setKonto(maKonto); // verheiratet mit Tom
        julia.setGehalt(3100.00);

        Firma adidos = new Firma(1000);
        adidos.setName("adidos");
        adidos.setKonto(firmenKonto);
        adidos.setOrt(java);
        //adidos.mitarbeiter = new de.samples.firma.daten.Mitarbeiter[] { tom, julia };
        adidos.einstellen(tom);
        adidos.einstellen(julia);

        Firma rehbock = new Firma(); // 100
        int standardAnzahl = Firma.STANDARD_ANZAHL;
        int standardAnzahl2 = Firma.STANDARD_ANZAHL;

        adidos.entlassen(tom);

        // Ort ändert seinen Namen
        java = new Ort("Java Insel", "12345");
        adidos.setOrt(java);

        //v.setFirmen(new Firma[]{adidos, rehbock});
        v.register(adidos);
        v.register(adidos);
        v.getFirmen().add(rehbock);

        // Iterieren
        for (Firma firma : v.getFirmen()) {
            System.out.println(firma.getName());
            // NICHT: firmen.remove(firma);
        }
        Collection<Firma> firmen = v.getFirmen();
        Iterator<Firma> iterator = firmen.iterator();
        while (iterator.hasNext()) {
            Firma firma = iterator.next();
            System.out.println(firma.getName());
            if (firma.getName().equals("adidos")) {
                iterator.remove();
                // NICHT: firmen.remove(firma);
            }
        }
        // als for
        for (Iterator<Firma> it = firmen.iterator(); it.hasNext(); ) {
            Firma firma = it.next();
            System.out.println(firma.getName());
            if (firma.getName().equals("adidos")) {
                it.remove();
                // NICHT: firmen.remove(firma);
            }
        }

        // Maps
        Map<String, Firma> firmenByName = new HashMap<>();
        firmenByName.put("adidos", adidos);
        Firma fa = firmenByName.get("adidos");
        Set<Map.Entry<String, Firma>> entries = firmenByName.entrySet();
        for (Map.Entry<String, Firma> entry : entries) {
            String key = entry.getKey();
            Firma value = entry.getValue();
        }

        for (Iterator<Mitarbeiter> it = adidos.iterator(); it.hasNext(); ) {
            Mitarbeiter ma = it.next();
            // ...
        }
        for (Mitarbeiter ma : adidos) { // adidos instanceof Iterable

        }

        // Sortierung nach Namen absteigend (impl. im Mitarbeiter)
        Collection<Mitarbeiter> mitarbeiterSortiert = new TreeSet<>();
        mitarbeiterSortiert.add(julia);
        mitarbeiterSortiert.add(tom);
        System.out.println("Sortiere Mitarbeiter: " + mitarbeiterSortiert);

        // Sortierung nach Alter
        Comparator<Mitarbeiter> comparator = (o1, o2) -> {
            int result = o1.getAlter() - o2.getAlter();
            return 0 != result ? result : 1;
        };
        comparator = Comparator.comparingInt(Mitarbeiter::getAlter);
        Collection<Mitarbeiter> mitarbeiterSortiert2 = new TreeSet<>(comparator);
        mitarbeiterSortiert2.add(julia);
        mitarbeiterSortiert2.add(tom);
        System.out.println("Sortiere Mitarbeiter: " + mitarbeiterSortiert2);

        // Vergleiche:
        // 1000 == 1000? Haben beide Konten gleich viel Geld?
        boolean gleicherStand = firmenKonto.getStand() == maKonto.getStand();

        // Teilen sich Tom und Julia dasselbe de.samples.firma.daten.Konto?
        boolean selbesKonto = tom.getKonto() == julia.getKonto();

        // Haben Tom und Julia DENSELBEN Namen (=1 Objekt)
        boolean nocheinVergleich = tom.getName() == julia.getName();
        // Semantisch: Haben Tom und Julia den GLEICHEN Namen (2 Objekte)
        boolean gleicherName = tom.getName().equals(julia.getName());

        Mitarbeiter nochEineJulia = new Mitarbeiter();
        nochEineJulia.setName("Julia");
        System.out.println(nochEineJulia.heißtWie(julia));
        Mitarbeiter nochEineWeitereJulia = new Mitarbeiter();
        nochEineWeitereJulia.setName(new String("Julia"));
        System.out.println(nochEineWeitereJulia.heißtWie(julia));

        try {
            adidos.gehaltZahlen(julia);
        } catch (KontoNichtGedecktException e) {
            e.printStackTrace();
        }
        adidos.gehaltZahlen();

        try {
            firmenKonto.überweisen(maKonto, 1000);
        } catch (KontoNichtGedecktException e) {
            e.printStackTrace();
        }
        // statische Methode
        try {
            Konto.überweisen(firmenKonto, maKonto, 1000);
        } catch (KontoNichtGedecktException e) {
            e.printStackTrace();
        }

        adidos.getReicheMitarbeiter()
          .skip(3) // nur die ersten 3
          .forEach(System.out::println);

        Mitarbeiter tom1 = adidos.findeNachNamen("Tom");
        if (tom1 != null) {
            // ...
            tom1.setAlter(20);
        }

        adidos.findeNachNamenMitOptional("Tom")
          .ifPresent(m -> m.setAlter(20));

        // try~finally / AutoCloseable-Interface
        try {
            OutputStream out = new FileOutputStream("text.txt");
            try {
                out.write(5);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // OutputStream erbt von AutoCloseable
        try (OutputStream out = new FileOutputStream("text.txt")) {
            out.write(5);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Wrappertypen
        int x = 0;
        Integer xx = Integer.valueOf(x);
        x = xx.intValue();
        xx = null;
        boolean b = false;
        Boolean bb = Boolean.valueOf(b);
        b = bb.booleanValue();
        // Autoboxing / Autounboxing
        xx = x; // kurz für xx = Integer.valueOf(x)
        // xx = null; --> NPE in folgender Zeile
        x = xx; // kurz für x = xx.intValue(); => NPE?

        // Hilfsklassen -> nur statische Funktionen
        // nicht gewollt: System system = new System();
        long time = System.currentTimeMillis();
        double acos = Math.acos(0.5);

    }

}
