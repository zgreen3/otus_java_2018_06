package ru.otus.l2_1.H_W;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.function.Supplier;
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
    private static final int size = 20_000_000;

    public static void main(String... args) throws InterruptedException {
        //Supplier<Object> splrObj = Object::new; //() -> new Object();
        //Supplier<String> splrStr = String::new; //() -> new String("")
        //Supplier<ArrayList<String>> splrArrLst = ArrayList<String>::new; //() -> new ArrayList()

        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        /*****?!не понимаю, зачем в изначальном коде Виталия был заложен этот бесконечный цикл, из-за того, что мы не можем быть на 100% уверенными
         * в том, когда произойдёт garbage collection?!*****
         * */
        //System.out.println("Starting the loop");
        //while (true) {

            printSizeOf(() -> new Object());

            printSizeOf(() -> new String(""));

            printSizeOf(() -> new ArrayList<String>());
        //}
    }

    private static long getMem() throws InterruptedException {
        System.gc();
        Thread.sleep(10);
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    private static <T> void printSizeOf(Supplier<T> classTInstance) throws InterruptedException {
        System.out.println("_____________________________________________________________________");

        long mem = getMem();
        System.out.println("Mem: " + mem);

        //*****?!пока не совсем понимаю, как избежать "java generic array creation error", если вместо new Object[size] написать new T[size]?!*****
        T[] array = (T[]) new Object[size];

        long mem2 = getMem();
        System.out.println("Ref size: " + (mem2 - mem) / array.length);

        for (int i = 0; i < array.length; i++) {
            array[i] = classTInstance.get(); //"Object" //"EmptySting" //"EmptyArrayList" //etc
        }

        long mem3 = getMem();
        System.out.println("Element size: " + (mem3 - mem2) / array.length);

        array = null;
        System.out.println("Array is ready for GC");

        Thread.sleep(1000); //wait for 1 sec
    }
}
