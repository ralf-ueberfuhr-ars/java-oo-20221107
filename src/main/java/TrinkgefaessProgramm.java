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

        // Schreibtisch
        Schreibtisch schreibtisch = new Schreibtisch();
        schreibtisch.farbe = "eiche";
        schreibtisch.breite = 200;
        schreibtisch.höhe = 85;
        schreibtisch.absenken(3);
        System.out.println(schreibtisch.höhe);

        meinKaffeeTasse.ort = schreibtisch;
        meinGlass.ort = schreibtisch;

        meinKaffeeTasse.ort.absenken(4);
        System.out.println(schreibtisch.höhe);
        System.out.println(meinGlass.ort.höhe);


    }

}
