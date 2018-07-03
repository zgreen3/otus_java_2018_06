package my.first.test.pack;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTestClass {

    public static void main(String[] args) {
        List<String> names = new ArrayList<String>(Arrays.asList("World", "2.0"));
        System.out.println("Hello, " + Joiner.on(", ").join(names));
    }

}
