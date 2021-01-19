package io.learn.threads.tclass;

class RevSeqPrinter implements Runnable {

    String name;
    

    @Override
    public void run() {
        for(int i = 919; i >= 900; i--) {
            System.out.print(name + " " + i + ", ");
            if(i % 5 == 0)
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
        for(int i = 901; i <= 920; i++) {
            System.out.print(this.getName() + " " + i + ", ");
            if(i % 5 == 0)
                System.out.println("Line Break...");
        }
    }
}

public class App {
    public static void main(String[] args) {
        
        // Class extends Thread
        // for(int i =0; i < 5; i++)
        //     new SeqPrinter().start();
        // System.out.println();

        // // Class implements Runnable
        // for(int i =0; i < 5; i++)
        //     new Thread(new RevSeqPrinter("Thread-" + i)).start();
        // System.out.println();

        // // Annonymous Class
        // for(int i=0; i < 5; i++) 
        //     new Thread(new Runnable() {
        //         @Override
        //         public void run() {
        //             for(int i = 0; i < 10; i++)
        //                 System.out.print(i + " ");   
        //         }  
        //     }).start();
        
        // Lambda
        for(int i = 0; i < 5; i++)
            new Thread(() -> {
                for(int j = 5; j >= 0; j--)
                 System.out.print(j + " ");}
                ).start();
    }
}