import java.util.*;
import java.util.Arrays;

public class IndianCoins {
    
    public static void main(String args[]) {
        int coins[] = {20,10,5,50,100,2000,500,1,2};
        int V = 590;
        Arrays.sort(coins);
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=coins.length-1; i>=0; i--) {
            if(coins[i] <= V) {
                while(coins[i] <= V) {
                    ans.add(coins[i]);
                    count++;
                    V -= coins[i];
                }
            }
        }

        System.err.println("Total Minimum Notes Can be Exchanged By Value = "+ count);
        System.out.print("Notes given for exchage are : ");
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
