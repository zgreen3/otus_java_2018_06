package ru.otus.l21;

public class CLMain {
    public static void main(String[] args) {

        System.out.println("Classloader of this class:"
                + CLMain.class.getClassLoader());

        System.out.println("Classloader of String:"
                + String.class.getClassLoader()); //bootstrap class loader is written in native code

    }
}
