package ru.otus.l2_1.H_W;

import java.lang.management.ManagementFactory;

/**
 * VM options -Xmx512m -Xms512m
 * -XX:+UseCompressedOops //on
 * -XX:-UseCompressedOops //off
 * <p>
 * Runtime runtime = Runtime.getRuntime();
 * long mem = runtime.totalMemory() - runtime.freeMemory();
 * <p>
 * System.gc()
 * <p>
 * jconsole, connect to pid
 */
@SuppressWarnings({"RedundantStringConstructorCall", "InfiniteLoopStatement"})
public class Main {
    public static void main(String... args) throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        int size = 20_000_000;

        Factory newFactory = new Factory();

        System.out.println("Starting the loop");
        while (true) {
            long mem = getMem();
            System.out.println("Mem: " + mem);

            Object[] array = new Object[size];

            long mem2 = getMem();
            System.out.println("Ref size: " + (mem2 - mem) / array.length);

            for (int i = 0; i < array.length; i++) {
                array[i] = newFactory.createNewTestObject("EmptyArrayList"); //"Object"); //"EmptySting"); //"EmptyArrayList");
            }

            long mem3 = getMem();
            System.out.println("Element size: " + (mem3 - mem2) / array.length);

            array = null;
            System.out.println("Array is ready for GC");

            Thread.sleep(1000); //wait for 1 sec
        }
    }

    private static long getMem() throws InterruptedException {
        System.gc();
        Thread.sleep(10);
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
