package io.learn.threads.legacy.create;

/**
 * @author Anuj Jain
 * Create thread using annonymous class
 */
public class Tannonymous {
    public static void main(String[] args) {

        // Annonymous Class
        for (int i = 0; i < 10; i++)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Started annonymous" + Thread.currentThread().getName());
                    for (int i = 0; i < 10; i++)
                        System.out.print(Thread.currentThread().getName() + " " + i);
                        System.out.println("Completed annonymous" + Thread.currentThread().getName());
                }
            }).start();


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}