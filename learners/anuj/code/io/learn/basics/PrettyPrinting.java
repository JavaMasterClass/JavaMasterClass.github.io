package io.learn.basics;

public class PrettyPrinting {
    public static void main(String[] args) {
        int salary = Integer.MAX_VALUE;
        int tax = Integer.MIN_VALUE;

        // Regular
        System.out.printf("Salary %d%n",salary);
        System.out.printf("   Tax %d%n",tax);
        System.out.println();

        // comma
        System.out.printf("Comma Salary %,d%n",salary);
        System.out.printf("Comma    Tax %,d%n",tax);
        System.out.println();

        // space
        System.out.printf("Space Salary % ,d%n",salary);
        System.out.printf("Space    Tax % ,d%n",tax);
        System.out.println();

        // sign
        System.out.printf("Sign Salary %+,d%n",salary);
        System.out.printf("Sign    Tax %+,d%n",tax);
        System.out.println();
        
        // ()
        System.out.printf("() Salary % (,d%n",salary);
        System.out.printf("()    Tax % (,d%n",tax);
        System.out.println();

    }
}
