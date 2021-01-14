package io.solution.l1a1;

import java.util.Arrays;

public class Human {

    public enum Sex {
        MALE, FEMALE
    }

    public enum Event {
        BIRTHDAY,
        ANNIVERSARY,
        FIGHT,
        DIVORSE
    };

    private String name;
    private Sex gender;
    private int cash;
    private double assets;

    public Human() {
    }

    public Human(String name) {
        this.name = name;
        this.gender = Sex.FEMALE;
    }

    public Human(String name, Sex gender) {
        this.name = name;
        this.gender = gender;
    }

    public Human(String name, Sex gender, int cash, double assets) {
        this(name, gender);
        this.cash = cash;
        this.assets = assets;
    }

    class Spouse {
        public int goodSpouse(String... events) {
            for(String event: events) {
                try {
                    goodSpouse(Event.valueOf(event));
                } catch(IllegalArgumentException e) {
                    System.out.printf("%s %s %s %s %s%n", "Event", event, "is not valid.", "Events:", Arrays.asList(Event.values()));
                }
            }
            return cash;
        }
        
        private int goodSpouse(Event event) {
            switch(event) {
                case BIRTHDAY:
                    reduceCash(1);
                    break;
                case ANNIVERSARY:
                    reduceCash(2);
                    break;
                case FIGHT:
                    reduceCash(5);
                    break;
                case DIVORSE:
                    reduceCash(50);                    
                    reduceAssets(50);
                    break;
                default:
                    System.out.printf("%s %s%n", "Invalid event can't be processed, Valid events:", Arrays.asList(Event.values()));
            }
            return cash;
        }

        private void reduceCash(int percentage) {
            cash = cash-(cash*percentage/100);
        }

        private void reduceAssets(int percentage) {
            assets = assets-(assets*percentage/100);
        }
    }

    public static void main(String[] args) {

        Human ramesh = new Human("Ramesh", Sex.MALE, 10000, 250000);
        assert(ramesh.name == "Ramesh");
        assert(ramesh.cash == 10000);
        assert(ramesh.assets == 250000);

        Human.Spouse spouse = ramesh.new Spouse(); 
        spouse.goodSpouse();
        spouse.goodSpouse("angry");
        assert(ramesh.cash == 10000);
        spouse.goodSpouse("ANNIVERSARY");
        assert(ramesh.cash == 9800);
        spouse.goodSpouse("BIRTHDAY", "FIGHT", "DIVORSE");
        System.out.println(ramesh);
    }

    @Override
    public String toString() {
        return String.format("%s%.2f %s %d %s %s %s %s%s%n", "Human [assets=", assets,  ", cash=", cash, ", gender=", gender, ", name=", name, "]" );
    }
}