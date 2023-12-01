import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class DiffHashMaps {
    public static void main(String args[]) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("USA", 120);
        lhm.put("UK", 102);
        //System.out.println(lhm);

        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("Saloni", 187);
        tm.put("Sakshi", 186);
        tm.put("Parkhi", 166);
        tm.put("Prakhar", 167);
        tm.put("Riya", 180);
        System.out.println(tm);

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("USA", 120);
        hm.put("UK", 102);
        System.out.println(hm);
    }
}
