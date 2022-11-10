package de.samples;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionSample {

    public static void main(String[] args)
      throws ClassNotFoundException,
      NoSuchMethodException,
      InvocationTargetException,
      InstantiationException,
      IllegalAccessException {

        // ohne Reflection
        {
            Book b = new Book();
            b.setTitle("Mein Buch");
            System.out.println(b);
        }
        // mit Reflection
        {
            Class<?> bookClass = Class.forName("de.samples.Book");
            Object b = bookClass.getDeclaredConstructor().newInstance();
            Method setTitleMethod = bookClass.getDeclaredMethod("setTitle", String.class);
            setTitleMethod.invoke(b, "Mein Buch");
            System.out.println(b);

        }

    }

}
