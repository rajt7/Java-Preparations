package MapDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args){
        Map<Integer, String> map = new HashMap<>();

        map.put(101, "Maths");
        map.put(105, "Science");
        map.put(103, "Social Science");

        System.out.println(map);

        // Iterating over map using keys
        Set<Integer> keys = map.keySet();
        for(Integer key: keys)
            System.out.println(key + "  " + map.get(key));
    }
}
