package io.learn.gc;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemory {
    public static void main(String[] args) {
        List<Object> infi = new ArrayList<>();
        while(true) infi.add(new Object());
    }
}
