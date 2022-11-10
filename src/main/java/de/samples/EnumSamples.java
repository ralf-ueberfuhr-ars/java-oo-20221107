package de.samples;

import de.samples.enums.Month;

import java.util.Calendar;

public class EnumSamples {

    // Beispiel: KartenFarbe
    enum Kartenfarbe {

        KARO(9), HERZ(10), KREUZ(11), PIK(12);

        private final int wert;

        Kartenfarbe(int wert) {
            this.wert = wert;
        }

        public int getWert() {
            return wert;
        }

    }

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2022, 123, 10);
        System.out.println(cal);

        Month month = Month.JAN;
        Month month2 = Month.JAN;
        for (Month m : Month.values()) {
            System.out.println(m);
        }
        String name = month.name(); // "JAN"
        int ordinal = month.ordinal(); // 0;

        Kartenfarbe farbe = Kartenfarbe.KREUZ;
        int kartenwert;
        switch (farbe) {
        case KARO:
            kartenwert = 9;
        case HERZ:
            kartenwert = 10;
        case PIK:
            kartenwert = 11;
        case KREUZ:
            kartenwert = 12;
        }
        kartenwert = farbe.getWert();
        int kartenwertHerz = Kartenfarbe.HERZ.getWert();

    }

}
