import java.util.HashMap;
import java.util.*;

public class MapsBasics {

    public static void main(String args[]) {
        HashMap<String,Integer> map = new HashMap<>();

        //put operation
        map.put("india", 8);
        map.put("America", 10);
        map.put("canada", 6);
        //System.out.println(map);

        //get opertaion
        // int usVAl = map.get("America");
        // System.out.println(usVAl);

        // // isConstainsKey operation
        // System.out.println(map.containsKey("russia"));
        // //remove() operation
        
        // System.out.println(map.remove("canada"));
        // System.out.println(map);

        // //get size
        // System.out.println(map.size());

        // //isEmpty()
        // System.err.println(map.isEmpty());
        
        // //clear operation
        // map.clear();
        // System.out.println(map.isEmpty());




        //😁Iteration on Maps
        Set<String> keys = map.keySet();
        System.out.print(keys);
        System.out.println();
        for (String s : keys) {
            System.out.println("Key = " + s + ", Correspond Value " + map.get(s));
        }

        //🤩Alternative of Iteration
        System.out.println( map.entrySet());
    }
}