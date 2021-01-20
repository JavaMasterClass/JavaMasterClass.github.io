package io.learn.threads.legacy.create;

/**
 * @author Anuj Jain
 * Create thread by implementing Runnable interface
 */
class Trunnable implements Runnable {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) new Thread(new Trunnable()).start();
        
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.printf("%n%s %s %n", "Started Runnable", Thread.currentThread().getName());
        
        for (int i = 0; i < 10; i++)
            System.out.printf("%s %d", Thread.currentThread().getName(), i);

        System.out.printf("%n%s %s%n", "Completed Runnable", Thread.currentThread().getName());
    }
}