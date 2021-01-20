package io.learn.threads.legacy.create;

class RevSeqPrinter implements Runnable {

    @Override
    public void run() {
        System.out.printf("%s %s %n", "Started Runnable", Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s %d ", Thread.currentThread().getName(), i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf(" %s %s%n", "Completed Runnable", Thread.currentThread().getName());
    }
}

class SeqPrinter extends Thread {

    @Override
    public void run() {
        for (int i = 901; i <= 920; i++) {
            System.out.print(this.getName() + " " + i + " ");
        }
        System.out.println();
    }
}
/**
 * @author Anuj Jain
 */
public class App {
    public static void main(String[] args) {

        // Class extends Thread
        for (int i = 0; i < 5; i++)
            new SeqPrinter().start();
        System.out.println();

        // Class implements Runnable
        for (int i = 0; i < 10; i++)
            new Thread(new RevSeqPrinter()).start();

        // Annonymous Class
        for (int i = 0; i < 10; i++)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Started annonymous" + Thread.currentThread().getName());
                    for (int i = 0; i < 10; i++)
                        System.out.println(Thread.currentThread().getName() + " " + i);
                        System.out.println("Completed annonymous" + Thread.currentThread().getName());
                }
            }).start();

        // Lambda
        for (int i = 0; i < 20; i++)
            new Thread(() -> {
                for (int j = 5; j >= 0; j--)
                    System.out.printf("%s %s %d", "Lambda:", Thread.currentThread().getName(), j);
                System.out.println();
            }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}