package io.learn.threads.legacy.create;

/**
 * @author Anuj Jain
 * Create thread using lambda function
 */
public class Tlambda {
    public static void main(String[] args) {
        // Lambda
        for (int i = 0; i < 20; i++)
            new Thread(() -> {
                System.out.printf("%n%s %s ", "Started", Thread.currentThread().getName());
                for (int j = 20; j >= 0; j--)
                    System.out.printf("%s %s %d ", "Lambda:", Thread.currentThread().getName(), j);
                System.out.printf("%n%s %s ", "Completed", Thread.currentThread().getName());
                }).start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
