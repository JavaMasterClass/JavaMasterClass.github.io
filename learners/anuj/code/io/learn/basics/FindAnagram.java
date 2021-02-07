package io.learn.basics;

public class FindAnagram {
    public static void main(String[] args) {
        String[] input = {"cat!!", "actB", "lower", "listen", "silent",
                            "greater", "werol", "eatergr", "adobe", 
                            "wow", "win", "winner", "pin", "abode", "nip"};
        printAnagrams(input);
    }

    static void printAnagrams(String[] input) {
        int[] s2i = new int[input.length];
        for(int i = 0; i < input.length; i++) {
            s2i[i] = stringToNumber(input[i]) + input[i].length();
        }
        for(int i=0; i < s2i.length; i++) {
            for(int j =0; j < s2i.length && j != i; j++) {
                if(s2i[j] == s2i[i]) {
                    System.out.printf("%s - %s%n", input[i], input[j]);
                }
            }
        }
    }

    static int stringToNumber(String value) {
        int index = value.length();
        int sum = 0;
        while(index > 0) {
            sum += (int) value.charAt(--index);
        }
        return sum;
    }
}
