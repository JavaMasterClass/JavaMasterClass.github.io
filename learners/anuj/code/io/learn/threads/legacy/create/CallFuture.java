package io.learn.threads.legacy.create;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Run a task using Callable<T> returning a result
 */
public class CallFuture {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future = executor.submit(new Callable<Integer>() {

            @Override
            public Integer call() {
                Random random = new Random();
                int duration = random.nextInt(4000);
                System.out.println("Starting...");
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");
                return duration;
            }
        });

        executor.shutdown();
        
        try {
            System.out.println("Worked for: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
