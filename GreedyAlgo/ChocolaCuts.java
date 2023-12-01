import java.util.*;

//Also Known as Min cost of cutting board into pieces
public class ChocolaCuts {
    
    public static void main(String args[]) {
        int n = 4, m = 6;
        Integer costVer[] = {2,1,3,1,4};
        Integer costHor[] = {4,1,2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hP = 1, vP = 1;
        int cost = 0;
        while(h < costHor.length && v < costVer.length) {
               
            if(costHor[h] <= costVer[v]) {
                  cost += costVer[v]*hP;
                  vP++;
                  v++;
               }
               else{
                cost += costHor[h]*vP;
                hP++;
                h++;
               }
        }
        //Remaining Hor Cuts
        while(h < costHor.length) {
            cost += costHor[h]*vP;
            hP++;
            h++;
        } 
        //Remaining Ver Cuts
        while(v < costVer.length) {
             cost += costVer[v]*hP;
             vP++;
             v++;
        }

       System.out.println("Minimum Cost of cuts : "+ cost);
    }
}
