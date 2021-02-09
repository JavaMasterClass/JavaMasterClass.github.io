package io.learn.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class GCInfo {
    public static void main(String[] args) {
        List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean bean: list) {
            System.out.printf("%s %s%n", "Name:", bean.getName());
            System.out.printf("%s %s%n", "#Collections:", bean.getCollectionCount());
            System.out.printf("%s %s%n", "Collection time:", bean.getCollectionTime());
            System.out.println("Pool Names");
            for(String name: bean.getMemoryPoolNames()) {
                System.out.printf("  %s%n", name);
            }
            System.out.println();
        }
    }
}