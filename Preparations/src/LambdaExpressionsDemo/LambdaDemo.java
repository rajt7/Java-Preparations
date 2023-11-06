package LambdaExpressionsDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

interface A{
    public void show();
}

public class LambdaDemo {
    public static void main(String[] args){
        // A a = () -> {
        //     {
        //         System.out.println("this is anonymous inner class demo..");
        //     }
        // };
        // a.show();

        A a = () -> System.out.println("this is lambda syntax..");
        a.show();

        List<Integer> list = Arrays.asList(23, 100, 12, 10, 1, 45, 600);
        list.forEach((x) -> System.out.print(x + " "));
        System.out.println();

        Stream<Integer> stream = list.stream();
        long count = stream.count();
        System.out.println("Number of values: " + count);
        // stream.forEach((x) -> System.out.print(x + " "));

        // Doubling the values
        list.stream().map((t) -> t*2).forEach((t) -> System.out.print(t + " "));
        System.out.println();

        // printing only odd values
        list.stream().filter((t) -> (t%2==1)).forEach((t) -> System.out.print(t + " "));
    }
}
