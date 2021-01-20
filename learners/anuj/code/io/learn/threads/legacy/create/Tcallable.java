package io.learn.threads.legacy.create;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Anuj Jain
 * Run a task using Callable<T> returning a result
 */
public class Tcallable {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futures = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
        
            Future<Integer> future = executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() {
                    Random random = new Random();
                    int duration = random.nextInt(4000);
                    System.out.printf("%s %s%n", "Started Callable", Thread.currentThread().getName());
                    try {
                        Thread.sleep(duration);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("%s %s%n", "Completed Callable", Thread.currentThread().getName());
                    return duration;
                }
            });

            futures.add(future);
        }

        executor.shutdown();
        
        try {
            for(Future<Integer> future: futures) System.out.println("Worked for: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
