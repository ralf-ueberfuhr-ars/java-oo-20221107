public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // Primitive Datentypen
        long zahl1 = 4L; // ganzzahlig, 64-bit
        int zahl2 = 4; // ganzzahlig, 32-bit --> Standard
        zahl1 = 4; // 4=int, impl. TypeCast
        short zahl3 = 4; // ganzzahlig, 16-bit
        byte zahl4 = 4; // ganzzahlig, 8-bit
        double zahl5 = 4.0; // Gleitkommazahl, 64-bit --> Standard

        float zahl6 = 4.0F; // Gleitkommazahl, 32-bit
        zahl6 = (float) 4.0; // expl. TypeCast

        boolean b1 = true; // 1-bit
        char c1 = 'a'; // 1 Zeichen

        // Sonderschreibweisen
        zahl1 = 0x10; // hex.: 16
        System.out.println(zahl1);
        zahl1 = 0b10; // binär: 2
        System.out.println(zahl1);
        zahl1 = 010; // oktal: 8
        System.out.println(zahl1);
        zahl1 = 123_456_789; // Trennzeichen
        c1 = '\n'; // Zeilenumbruch
        c1 = '\t'; // Tab-Zeichen
        c1 = '\"'; // "
        c1 = '\\'; // \
        c1 = '\u00a5';
        System.out.println(c1);

        // Operatoren
        zahl1 = zahl1 + 1; // - * /
        zahl1++; // kurz
        zahl1 += 1; // kurz
        zahl1 *= 10; // kurz für zahl1 = zahl1 * 10;

        b1 = true && false; // AND
        b1 = true || false; // OR
        b1 = !b1; // NOT

        // Type Inference
        var zahl = 4;

        // Arrays
        int[] zahlen = { 4, 6, 1, 9 };
        zahlen[1] = 10; // {4, 10, 1, 9}
        System.out.println(zahlen.length);
        // Alternativen
        int zahlen2[] = { 1, 4 };
        zahlen = new int[]{}; // leeres Array = Array mit Länge 0
        zahlen = new int[0]; // leeres Array
        zahlen = new int[5]; // { 0, 0, 0, 0, 0}


    }

}
