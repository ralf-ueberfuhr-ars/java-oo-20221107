package de.samples.firma.start;

import de.samples.firma.daten.Firma;
import de.samples.firma.daten.Firmenverwaltung;
import de.samples.firma.daten.Konto;
import de.samples.firma.daten.Mitarbeiter;
import de.samples.firma.daten.Ort;

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
        if(tom.getName() != null) {
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

        v.setFirmen(new Firma[]{adidos, rehbock});

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

        adidos.gehaltZahlen(julia);
        adidos.gehaltZahlen();

        firmenKonto.überweisen(maKonto, 1000);
        // statische Methode
        Konto.überweisen(firmenKonto, maKonto, 1000);


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
