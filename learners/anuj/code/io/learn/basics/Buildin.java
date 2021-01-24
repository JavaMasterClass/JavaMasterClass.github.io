package io.learn.basics;

public class Buildin {

    public static void main(String[] args) {
        // What is the output (a) 20.0 (b) > 20.0 (c) < 20.0
        double total = 0.2;
        for(int i=1; i < 100; i++)
            total += 0.2;
        System.out.println(total);
    }
}