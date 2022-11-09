package de.samples.trinken;

public class Brot {

    // static Zutat mehl = new Zutat();

    private String name;

    // inner class
    private class Zutat {

        { // Objektbezug auf 1 Brot-Objekt
            Brot.this.name = "";
        }

    }

    private static class StaticZutat {

        { // KEIN Objektbezug auf 1 Brot-Objekt
            // Brot.this.name = ""; --> Fehler!
        }

    }

    public static void main(String[] args) {
        Brot brot = new Brot();
        StaticZutat sZutat = new StaticZutat();
        Zutat zutat = brot.new Zutat();

        Brot brot2 = new Brot();
        Zutat zutat2 = brot2.new Zutat();

    }

}
