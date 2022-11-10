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

        Möbelstück m3 = new Schreibtisch() { // anonyme Klasse = Unterklasse
            void absenken(int differenz) {
                System.out.println("Ällerbätsch!");
            }
        };
        m3.höhe = 100;
        absenken(m3);

        meinKaffeeTasse.ort = schreibtisch;
        meinGlass.ort = schreibtisch;

        meinKaffeeTasse.ort.absenken(4);
        System.out.println(schreibtisch.höhe);
        System.out.println(meinGlass.ort.höhe);

    }

    private static void absenken(Möbelstück m) {
        m.absenken(10); // Polymorphie
        System.out.println("Höhe des Möbelstücks: " + m.höhe);
    }


}
