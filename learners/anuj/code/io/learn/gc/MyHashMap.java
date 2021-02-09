package io.learn.gc;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class MyHashMap {
    public static void main(String[] args) {
        // Strong reference
        Map<Person, Integer> m = new HashMap<>();
        Person a = new Person();
        m.put(a, 1);

        System.out.println("Strong reference");
        System.out.println(m.containsKey(a));
        System.out.println(m.containsValue(1));

        a = null;
        System.gc();

        System.out.println("Strong reference after GC");
        System.out.println(m.containsKey(a));
        System.out.println(m.containsValue(1));

        // Weak reference
        Map<Person, Integer> wm = new WeakHashMap<>();
        Person w = new Person();
        wm.put(w, 2);

        System.out.println("Weak reference");

        System.out.println(wm.containsKey(w));
        System.out.println(wm.containsValue(2));

        w = null;
        System.gc();

        System.out.println("Weak reference after GC");
        System.out.println(wm.containsKey(w));
        System.out.println(wm.containsValue(2));
    }
}

class Person {
    public Date birthdate;

    public Person() {
        birthdate = new Date();
    }

    @Override
    public String toString() {
        return "Person [birthdate=" + birthdate + "]";
    }
}
