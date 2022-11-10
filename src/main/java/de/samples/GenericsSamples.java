package de.samples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class GenericsSamples {

    static class Warenkorb<T> {

        private T inhalt;

        public T getInhalt() {
            return inhalt;
        }

        public void setInhalt(T inhalt) {
            this.inhalt = inhalt;
        }

    }

    public static <T> T first(T o1, T o2) {
        return o1;
    }


    public static void main(String[] args) {
        {
            Collection<String> col = new ArrayList<>();
            col.add("text");
            // col.add(4);
            String next = col.iterator().next();
        }
        {
            Collection<Integer> col = new ArrayList<>();
            col.add(4);
            // col.add(4);
            Integer next = col.iterator().next();
        }
        {
            Warenkorb w1 = new Warenkorb();
            w1.setInhalt("text");
            w1.setInhalt(1);
            Object inhalt = w1.getInhalt();
            if (inhalt instanceof String) {
                String inhaltAlsString = (String) inhalt;
                // ...
            }
        }
        {
            Warenkorb<String> w1 = new Warenkorb<>();
            w1.setInhalt("text");
            // w1.setInhalt(1);
            String inhalt = w1.getInhalt();
        }
        {
            Warenkorb<Integer> w1 = new Warenkorb<>();
            w1.setInhalt(4);
            // w1.setInhalt(1);
            Integer inhalt = w1.getInhalt();
        }
        String first1 = first("test", "test1");
        Integer first2 = first(2, 5);
        int first3 = first(2, 5);
        Object test1 = first(2, "test1");
        // keine Raw Types - Generics sind reine Compilerinfos --> beim Kompilieren entfernt

        Collection<String> namen = new LinkedList<>();
        namen.add("Tom");
        namen.add("Julia");
        {
            Collection col = namen; // raw type !!!
            col.add(1);
        }
        System.out.println(namen);
        for (String name : namen) {
            System.out.println(name);
        }

    }

}
