package io.learn.function;
import java.util.List;

import io.learn.basics.Hero;
import io.learn.basics.Planet;

public class FuncImplementaions {

    List<Hero> heros = List.of(
        new Hero(Planet.EARTH, "Shield", 5), 
        new Hero(Planet.EARTH, "Web-Shooters", 10), 
        new Hero(Planet.MARS, "Lasso", 20),
        new Hero(Planet.EARTH, "NewBee", 1)
        );
    public static void main(String[] args) {
        System.out.println("Functions");

        // Using regular classes
        FuncImplementaions f = new FuncImplementaions();
        SelectHeroImpl filter = new SelectHeroImpl();
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
    }

    public void deployHero(List<Hero> hList, SelectHero s) {
        for(Hero h: hList)
            if(s.select(h))
                System.out.printf("%s %s%n", "Selected", h);
    }
}
