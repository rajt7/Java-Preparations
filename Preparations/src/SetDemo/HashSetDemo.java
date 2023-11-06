package SetDemo;

import java.util.*;

public class HashSetDemo {

    public static void main(String[] args){
        Set<Integer> s = new HashSet<>();
        s.add(13);
        s.add(10);
        s.add(20);
        s.add(21);
        s.add(15);
        s.add(10);
        s.add(15);
        System.out.println(s);

        Set<Integer> s1 = new LinkedHashSet<>();
        s1.add(13);
        s1.add(10);
        s1.add(20);
        s1.add(21);
        s1.add(15);
        s1.add(10);
        s1.add(15);
        System.out.println(s1);

        Set<Integer> s2 = new TreeSet<>();
        s2.add(13);
        s2.add(10);
        s2.add(20);
        s2.add(21);
        s2.add(15);
        s2.add(10);
        s2.add(15);
        System.out.println(s2);
    }    
}
