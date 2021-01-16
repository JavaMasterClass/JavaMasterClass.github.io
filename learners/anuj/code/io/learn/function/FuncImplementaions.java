package io.learn.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import io.learn.basics.Hero;
import io.learn.basics.Planet;

public class FuncImplementaions {

    List<Hero> heros = List.of(
        new Hero(Planet.EARTH, "Shield", 5), 
        new Hero(Planet.EARTH, "Web-Shooters", 10), 
        new Hero(Planet.MARS, "Lasso", 21),
        new Hero(Planet.EARTH, "NewBee", 1)
        );
    public static void main(String[] args) {
        System.out.println("Functions");

        // Using regular classes
        FuncImplementaions f = new FuncImplementaions();
        SelectEarthHeros filter = new SelectEarthHeros();
        f.deployHero(f.heros, filter);

        // Using annonymous class
        f.deployHero(f.heros, new SelectHero(){
            @Override
            public boolean select(Hero h) {
                return h.damage == 1;
            }
        });

        // Using lambda
        f.deployHero(f.heros, p -> p.damage > 10);
        f.deployHero(f.heros, p -> p.damage < 9);
        f.deployHero(f.heros, p -> p.planet == Planet.EARTH);

        List<String> numberNames = new ArrayList<>(List.of("one", "two", "three", "four", "five", "hundred"));
        // Using Predicate
        f.topper(f.heros, p -> p.damage > 20);
        f.topper(numberNames, (String s) -> s.startsWith("h"));
    }

    // method accepting a list and functional interface
    public void deployHero(List<Hero> hList, SelectHero s) {
        for(Hero h: hList)
            if(s.select(h))
                System.out.printf("%s %s%n", "Selected", h);
    }

    // Generic method accepting a list and predicate
    public <T> void topper(List<T> list, Predicate<T> filter) {
        for(T o: list) {
            if(filter.test(o))
                System.out.printf("%s %s%n", "Topper:", o);
        }
    }
}
