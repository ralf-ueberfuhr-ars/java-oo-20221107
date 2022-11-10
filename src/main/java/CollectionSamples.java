import de.samples.firma.daten.Konto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class CollectionSamples {

    public static void main(String[] args) {

//        Collection<Integer> list = new HashSet<>();
  //      fill(list);
        System.out.println(fill(new HashSet<>()));
        System.out.println(fill(new TreeSet<>()));
        System.out.println(fill(new LinkedList<>()));

        // abstrakt
        // System.out.println(fill(new Collection<>()));

    }

    private static Collection<Integer> fill(Collection<Integer> col) {
        col.add(4);
        col.add(3);
        col.add(7);
        col.add(4);
        col.add(-200);
        return col;
    }

}
