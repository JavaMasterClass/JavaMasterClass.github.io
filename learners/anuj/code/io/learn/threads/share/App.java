package io.learn.threads.share;

public class App {
    private int count = 0;

    public static void main(String[] args) {
        App app = new App();
        app.updateCount();

        System.out.printf("%d%n", app.getCount());
    }

    private void updateCount() {
        Thread worker1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++)
                    count++;
            }
        });

        Thread worker2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++)
                    count++;
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
        return count;
    }    
}
