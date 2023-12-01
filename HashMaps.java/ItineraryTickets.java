import java.util.*;

public class ItineraryTickets {

    public static String getStartPoint(HashMap<String, String> tickets) {
        //Create reverseMap
        HashMap<String, String> revMap = new HashMap<>();
           for (String key : tickets.keySet()) {
                revMap.put(tickets.get(key), key);
           }
        //find Starting Point which is not exist in revMap And exist in Original map
        for (String key : tickets.keySet()) {
            if(!revMap.containsKey(key)) {
                return key; //Starting point found
            }
        }
        return null;
    }
    public static void main(String args[]) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Delhi", "Goa");
        tickets.put("Goa", "Chennai");
        
        String start = getStartPoint(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()) {
            System.out.print(" -> " +tickets.get(start));
            start = tickets.get(start);
        }
        System.err.println();
    }
}