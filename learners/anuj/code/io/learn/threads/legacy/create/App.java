package io.learn.threads.legacy.create;

class RevSeqPrinter implements Runnable {

    String name;

    @Override
    public void run() {
        for (int i = 919; i >= 900; i--) {
            System.out.print(name + " " + i + ", ");
            if (i % 5 == 0)
                System.out.println("Line Break...");
        }
    }

    public RevSeqPrinter(String name) {
        this.name = name;
    }

}

class SeqPrinter extends Thread {

    @Override
    public void run() {
        for (int i = 901; i <= 920; i++) {
            System.out.print(this.getName() + " " + i + ", ");
            if (i % 5 == 0)
                System.out.println("Line Break...");
        }
    }
}

public class App {
    public static void main(String[] args) {

        // Class extends Thread
        for (int i = 0; i < 5; i++)
            new SeqPrinter().start();
        System.out.println();

        // // Class implements Runnable
        for (int i = 0; i < 5; i++)
            new Thread(new RevSeqPrinter("Thread-" + i)).start();
        System.out.println();

        // // Annonymous Class
        for (int i = 0; i < 500; i++)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Started " + Thread.currentThread().getName());
                    for (int i = 0; i < 10; i++)
                        System.out.println(Thread.currentThread().getName() + " " + i);
                        System.out.println("Completed " + Thread.currentThread().getName());
                }
            }).start();

        // Lambda
        for (int i = 0; i < 5000; i++)
            new Thread(() -> {
                for (int j = 5; j >= 0; j--)
                    System.out.printf("%s %s %d", "Lambda:", Thread.currentThread().getName(), j);
                System.out.println();
            }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}