package io.learn.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import io.learn.basics.Hero;
import io.learn.basics.Planet;

/**
 * Showcase Lambda functions (Supplier, Consumer, Predicate, Function)
 * @author Anuj Jain
 */
public class BasicLambda {
    public static void main(String[] args) {

        // Supplier
        Supplier<Long> supplier = () -> Math.round(Math.random() * 1000);
        System.out.printf("%s %d%n", "Supplier Output:", supplier.get());

        // Consumer
        Consumer<String> consumer = (String message) -> System.out.printf("%s %s%n", "Consumer Output:", message);
        consumer.accept("Hello World!");

        // Predicate
        List<String> numberNames = new ArrayList<>(List.of("one", "two", "three", "four", "five"));

        Predicate<String> filter = (String s) -> s.startsWith("t");
        numberNames.removeIf(filter);
        numberNames.forEach(consumer);
        

        // Function
        List<Hero> heros = List.of(new Hero(Planet.EARTH, "Shield", 5), new Hero(Planet.EARTH, "Web-Shooters", 10), new Hero(Planet.MARS, "Lasso", 20));
        List<String> weapons = new ArrayList<>();

        Function<Hero, String> toWeapon = hero -> hero.getSecretWeapon();
        
        for(Hero hero: heros)
            weapons.add(toWeapon.apply(hero));
        weapons.forEach(consumer);
    }    
}
