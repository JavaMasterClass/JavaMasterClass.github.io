package io.learn.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaChain {
    public static void main(String[] args) {
            // Consumer
            Consumer<String> c1 = message -> System.out.printf("%s %s%n", "Consumer c1 Output:", message);
            Consumer<String> c2 = message -> System.out.printf("%s %s%n", "Consumer c2 Output:", message);

            Consumer<String> c3 = c1.andThen(c2);
            c3.accept("Hello World!");

            // Predicate
            List<String> numberNames = new ArrayList<>(List.of("one", "two", "three", "four", "five", "six"));

            Predicate<String> startWithT = s -> s.startsWith("t");
            Predicate<String> startWithF = s -> s.startsWith("f");
            Predicate<String> p = startWithF.negate().and(startWithT.negate());

            numberNames.removeIf(p);
            numberNames.forEach(c1);            
    }
    
}
