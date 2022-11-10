package de.samples.trinken;

public class Trinkgefaess {

    String farbe;
    int volumen = 10; // ml
    int leerGewicht;
    int gewicht;

    private Möbelstück ort;

    // Rückgabetyp, Namen, Parameter, Impl.

    public Möbelstück getOrt() {
        return ort;
    }

    public void setOrt(Möbelstück ort) {
        if (null != ort) {
            // wenn ich mein Trinkgefäss auf ein Möbelstück platziere,
            // dann gibt es ein Geräusch
            String geräusch = "knack";
            // jedes Möbelstück (=jede Art) KANN ein eigenes Geräusch machen
            // @Geräusch(...) auslesen
            Class<? extends Möbelstück> möbelstückKlasse = ort.getClass();
            Geräusch annotation = möbelstückKlasse.getAnnotation(Geräusch.class);
            if (annotation != null) {
                geräusch = annotation.value();
            }
            System.out.println(geräusch);
        }
        this.ort = ort;
    }

    void ausschuetten() {
        gewicht = leerGewicht;
    }

    void fuellen(int fuellung) {
        gewicht = gewicht + fuellung;
    }

}
