package io.learn.function;

import io.learn.basics.Hero;
import io.learn.basics.Planet;

public class SelectEarthHeros implements SelectHero {

    @Override
    public boolean select(Hero hero) {
        return hero.planet == Planet.EARTH;
    }
}
