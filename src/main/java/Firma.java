public class Firma {

    String name;
    Ort ort;
    Konto konto;
    // {null, null, null, null, ...., null}
    Mitarbeiter[] mitarbeiter = new Mitarbeiter[100];


    // einstellen
    void einstellen(Mitarbeiter ma) {
        // TODO ist er schon drin?
        for (int i=0; i< mitarbeiter.length; i++) {
            if(mitarbeiter[i] == null) {
                mitarbeiter[i] = ma;
                break;
            }
        }
    }
    // entlassen
    void entlassen(Mitarbeiter ma) {
        for (int i=0; i< mitarbeiter.length; i++) {
            if(mitarbeiter[i] == ma) {
                mitarbeiter[i] = null;
                break;
            }
        }
    }

    // gehaltZahlen


}
