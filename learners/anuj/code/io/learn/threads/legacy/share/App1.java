package io.learn.threads.legacy.share;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * @author Anuj Jain
 * Solve Thread Interference using Automic variable
 */
public class App1 {

    private AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        App1 app = new App1();
        app.updateCount();
        System.out.printf("%d%n", app.getCount());
    }

    private void updateCount() {
        Thread worker1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++)
                    count.incrementAndGet();
            }
        });

        Thread worker2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++)
                count.incrementAndGet();
            }
        });

        worker1.start();
        worker2.start();

        try {
            worker1.join();
            worker2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getCount() {
        return count.get();
    }    
}
