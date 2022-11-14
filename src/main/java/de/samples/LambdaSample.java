package de.samples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaSample {

    private static double addiere(double d1, double d2) {
        return d1 + d2;
    }

    @FunctionalInterface
    private interface ZahlenGenerator {

        double generiere(); // nur 1 abstrakte Methode

    }

    private static double addiereBisGr10(ZahlenGenerator generator) {
        double sum = 0;
        while (sum <= 10) {
            sum += generator.generiere();
        }
        return sum;
    }

    private static double addiereBisGr10Standard(DoubleSupplier generator) {
        double sum = 0;
        while (sum <= 10) {
            sum += generator.getAsDouble();
        }
        return sum;
    }

    public static void main(String[] args) {
        // Addiere 2 Zahlen
        System.out.println(addiere(1.5, 3.6));
        // Addiere 2 Zufallszahlen
        System.out.println(addiere(Math.random(), Math.random()));
        // Addiere Zufallszahlen solange, bis ein Wert >10 herauskommt
        // (Entscheidung "Zufallszahlen" soll in der main-Methode bleiben)
        System.out.println(addiereBisGr10(new ZahlenGenerator() {
            @Override
            public double generiere() {
                return Math.random();
            }
        }));
        // Redundanzen (Type Inference)
        System.out.println(addiereBisGr10(/*new ZahlenGenerator() {
            @Override
            public double generiere*/() -> {
              return Math.random();
          }
          /*}*/));
        System.out.println(addiereBisGr10(
          () -> {
              return Math.random();
          }
        ));
        // Spezialfall: nur 1 Anweisung
        System.out.println(addiereBisGr10(() -> Math.random()));
        // Spezialfall: Parameter matchen
        System.out.println(addiereBisGr10(Math::random)); // Method Reference Operator

        // Java Standard-Interfaces
        Supplier<String> s1 = () -> "HelloWorld";
        System.out.println(s1.get());
        Supplier<Double> s2 = Math::random;
        DoubleSupplier s3 = Math::random;
        double ergebnis = addiereBisGr10Standard(Math::random);
        Supplier<Date> s4 = () -> new Date();
        Supplier<Date> s5 = Date::new;

        Consumer<String> c1 = s -> System.out.println(s);
        Consumer<String> c2 = System.out::println;

        Function<String, Integer> f1 = s -> Integer.valueOf(s);
        Function<String, Integer> f2 = Integer::valueOf;

        Predicate<String> p1 = s -> s.length() > 1;
        Predicate<String> p2 = String::isEmpty;
        boolean xyu = p2.test("xyu");

        // Collections / Streams
        List<String> namen = List.of("Tom", "Julia", "Alexander", "Clementine");
        // Aufgabe: alle kurzen Namen (<=5 Zeichen) in Großbuchstaben
        {
            List<String> neueNamen = new ArrayList<>();
            for (String name : namen) {
                if(name.length()<=5) {
                    neueNamen.add(name.toUpperCase());
                }
            }
            System.out.println(neueNamen);
        }
        {
            List<String> neueNamen = namen.stream()
              .filter(name -> name.length()<=5)
              .map(String::toUpperCase)
              .collect(Collectors.toList());
            System.out.println(neueNamen);
        }


    }

}
