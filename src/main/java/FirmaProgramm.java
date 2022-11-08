public class FirmaProgramm {

    public static void main(String[] args) {

        Ort java = new Ort();
        java.name = "JavaStadt";
        java.postleitzahl = "12345";

        Konto firmenKonto = new Konto();
        firmenKonto.nummer = "123456789";
        firmenKonto.stand = 1_234_567.89;

        Konto maKonto = new Konto();
        maKonto.nummer = "987654321";
        maKonto.stand = 1234.56;

        Mitarbeiter tom = new Mitarbeiter();
        System.out.println(tom.name);
        tom.name = null;
        if(tom.name != null) {
            // ...
            System.out.println(tom.name.toLowerCase());
        }
        tom.name = "Tom";
        tom.alter = 46;
        tom.konto = maKonto;
        tom.gehalt = 2900.00;

        Mitarbeiter julia = new Mitarbeiter();
        julia.name = "Julia";
        julia.alter = 35;
        julia.konto = maKonto; // verheiratet mit Tom
        julia.gehalt = 3100.00;

        Firma adidos = new Firma();
        adidos.name = "adidos";
        adidos.konto = firmenKonto;
        adidos.ort = java;
        //adidos.mitarbeiter = new Mitarbeiter[] { tom, julia };
        adidos.einstellen(tom);
        adidos.einstellen(julia);


        adidos.entlassen(tom);

        // Vergleiche:
        // 1000 == 1000? Haben beide Konten gleich viel Geld?
        boolean gleicherStand = firmenKonto.stand == maKonto.stand;

        // Teilen sich Tom und Julia dasselbe Konto?
        boolean selbesKonto = tom.konto == julia.konto;

        // Haben Tom und Julia DENSELBEN Namen (=1 Objekt)
        boolean nocheinVergleich = tom.name == julia.name;
        // Semantisch: Haben Tom und Julia den GLEICHEN Namen (2 Objekte)
        boolean gleicherName = tom.name.equals(julia.name);

        Mitarbeiter nochEineJulia = new Mitarbeiter();
        nochEineJulia.name = "Julia";
        System.out.println(nochEineJulia.heißtWie(julia));
        Mitarbeiter nochEineWeitereJulia = new Mitarbeiter();
        nochEineWeitereJulia.name = new String("Julia");
        System.out.println(nochEineWeitereJulia.heißtWie(julia));

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
        xx = null;
        x = xx; // kurz für x = xx.intValue(); => NPE?

    }

}
