package de.samples;

import de.samples.firma.daten.Konto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
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

    private static class MyCollection<T> implements Collection<T> {

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<T> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T1> T1[] toArray(T1[] a) {
            return null;
        }

        @Override
        public boolean add(T t) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends T> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }
    }

}
