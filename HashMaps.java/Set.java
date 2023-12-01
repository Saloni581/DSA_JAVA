import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.TreeSet;

public class Set {
   
    public static void main(String args[]) {
        // HashSet<Integer> set = new HashSet<>();
        // set.add(2);
        // set.add(3);
        // set.add(4);
        // set.add(4);
        // set.add(3);

        // System.out.println(set);
        // System.out.println(set.contains(3));
        // System.out.println(set.contains(1));

        // set.remove(3);
        // System.out.println(set.contains(3));
        // System.out.println(set.size());
        // set.clear();
        // System.out.println(set.isEmpty());



        //Iteration on HashSet
        HashSet<String> cities = new HashSet<>();
        cities.add("Vrindavan");
        cities.add("Ayodhya");
        cities.add("TirupatiBalaji");
        cities.add("JagannathPuri");

        LinkedHashSet<String> LHS = new LinkedHashSet<>();
        LHS.add("Vrindavan");
        LHS.add("Ayodhya");
        LHS.add("TirupatiBalaji");
        LHS.add("JagannathPuri");

        //Method 1 for traversing
        System.out.println("-- LinkedHashSet : ");
        Iterator it = LHS.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        //Method 2 for traversing
        System.out.println("-- HashSet : ");
        for (String city : cities) {
            System.out.println(city);
        }


        //🌳 TreeSet
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Vrindavan");
        ts.add("Ayodhya");
        ts.add("TirupatiBalaji");
        ts.add("JagannathPuri");
        System.out.println("*********Ordered ArrangeMent  Using TreeSet : ");
        System.out.println(ts);


        }
}
