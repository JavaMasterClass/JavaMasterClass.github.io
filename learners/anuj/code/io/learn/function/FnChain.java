package io.learn.function;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import io.learn.basics.Hero;
import io.learn.basics.Planet;

/**
 * @author Anuj Jain
 */
public class FnChain {
    public static void main(String[] args) {
    
    // List of Heros
    List<Hero> heros = List.of(
        new Hero(Planet.EARTH, "Shield", 5),
        new Hero(Planet.EARTH, "Web-Shooters", 10), 
        new Hero(Planet.MARS, "Lasso", 21),
        new Hero(Planet.EARTH, "NewBee", 1)
        );

        // functions
        Function<Hero, String> getWeapon = hero -> hero.getSecretWeapon();
        Function<String, String> reverse = s ->  new StringBuilder(s).reverse().toString();
        Function<String, String> ewith3 = s -> s.replace('e', '3');
        Function<String, String> threewithe = s -> s.replace('3', 'e');

        // combine funcitons
        Function<Hero, String> getReversedEncWeapon = getWeapon.andThen(reverse).andThen(ewith3);

        // Use funtion in steam map
        List<String> weapons = heros.stream().map(getReversedEncWeapon).collect(Collectors.toList());
        // fluid
        // heros.stream().map(getReversedEncWeapon).collect(Collectors.toList()).forEach(System.out::println);
        
        //print weapon codes
        System.out.printf("%s %s%n", "Hero Weapons:", weapons);

        // Original
        weapons.stream().map(reverse.andThen(threewithe)).collect(Collectors.toList()).forEach(System.out::println);

    }
}
