package io.learn.threads.legacy.create;

/**
 * @author Anuj Jain
 * Create threads by extendin Thread class
 */
class TsubclassThread extends Thread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) new TsubclassThread().start();
        
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
            System.out.printf("%n%s %s %n", "Started", getName());
            for (int i = 0; i < 10; i++)
                System.out.printf("%s %d", getName(), i);
    
            System.out.printf("%n%s %s%n", "Completed", getName());
    }
}