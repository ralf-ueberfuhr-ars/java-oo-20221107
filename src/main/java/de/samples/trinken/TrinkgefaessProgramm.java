package de.samples.trinken;

public class TrinkgefaessProgramm {

    public static void main(String[] args) {

        // Objekte erzeugen
        Trinkgefaess meinGlass = new Trinkgefaess();
        meinGlass.farbe = "transparent";
        meinGlass.volumen = 150;
        meinGlass.leerGewicht = 200;
        meinGlass.gewicht = 200;

        Trinkgefaess meinKaffeeTasse = new Trinkgefaess();
        meinKaffeeTasse.farbe = "schwarz";
        meinKaffeeTasse.volumen = 200;
        meinKaffeeTasse.leerGewicht = 200;
        meinKaffeeTasse.gewicht = 400;

        // Methoden aufrufen
        meinGlass.fuellen(100);
        System.out.println(meinGlass.gewicht); // 300
        System.out.println(meinKaffeeTasse.gewicht); // 400

        meinKaffeeTasse.ausschuetten();
        meinKaffeeTasse.fuellen(100);
        // oder:
        // meinKaffeeTasse.fuellen(-100);
        System.out.println(meinKaffeeTasse.gewicht); // 300

        // de.samples.trinken.Schreibtisch
        Schreibtisch schreibtisch = new Schreibtisch();
        schreibtisch.farbe = Möbelfarbe.EICHE;
        schreibtisch.breite = 200;
        schreibtisch.höhe = 85;
        schreibtisch.tischplattenGroesse = 100;
        schreibtisch.absenken(3);
        System.out.println(schreibtisch.höhe);

        Kommode kommode = new Kommode();

        // abstrakte Klasse
        // Möbelstück m = new Möbelstück();
        Möbelstück m = new Kommode();
        m.höhe = 100;

        // Überschreiben von Methoden
        // --> Dynamische Bindung
        absenken(m);

        Möbelstück m2 = new Schreibtisch();
        m2.höhe = 100;
        absenken(m2);
        m2.zeigeInhalt();

        Möbelstück m3 = new Schreibtisch() { // anonyme Klasse = Unterklasse
            @Override
            public void absenken(int differenz) {
                System.out.println("Ällerbätsch!");
            }
        };
        m3.höhe = 100;
        absenken(m3);

        meinKaffeeTasse.setOrt(schreibtisch);
        meinGlass.setOrt(schreibtisch);

        meinKaffeeTasse.getOrt().absenken(4);
        System.out.println(schreibtisch.höhe);
        System.out.println(meinGlass.getOrt().höhe);

        meinGlass.setOrt(kommode);
        meinGlass.setOrt(new Bett());

        m.zeigeInhalt();
        m2.zeigeInhalt();
        m3.zeigeInhalt();

        Object o = new Object();
    }

    private static void absenken(Höhenverstellbar m) {
        m.absenken(10); // Polymorphie
        // Ausnahmsweise:
        if(m instanceof Möbelstück) {
            Möbelstück möbel = (Möbelstück) m;
            System.out.println("Höhe des Möbelstücks (" + m.getClass().getName() + "): " + möbel.höhe);
        }
    }


}
