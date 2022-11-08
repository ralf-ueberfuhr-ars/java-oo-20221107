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
        adidos.mitarbeiter = new Mitarbeiter[] { tom, julia };

    }

}
