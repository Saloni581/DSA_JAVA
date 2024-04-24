import java.util.*;

public class ActivitySelection {
public static void main(String args[]) {
    //ASSUMPTION => ********Activities are sorted by their END TIME***********
    //TC => 0(n) + if sorting is not done already then -> 2d array sorting TC = 0(log(n))
    //In this way total Time Complexity will be : 0(nlogn)

    //Starting and Ending time of working
    // int startTime[] = {1,3,0,5,8,5};
    // int endTime[] = {2,4,6,7,9,9};

    // int maxAct = 0;
    // ArrayList<Integer> ansAct = new ArrayList<>();

    // //Default Select 1st Act -> then 
    // //1st Activity - The first activity always gets selected
    // maxAct = 1;
    // ansAct.add(0);  //choosing 1st Act 

    // int lastEnd = endTime[0];
    // //As we Know last Act's Time should be small or equal to my current Act OR
    // //My Current Act's Start point should be greater than or equal to my prev Act's EndTime
    // for(int i=1; i<endTime.length; i++) {
    //    if(startTime[i] >= lastEnd) {
    //     //Select Activity
    //     maxAct++;
    //     ansAct.add(i);
    //     lastEnd = endTime[i];
    //    }
    // }
    // System.out.println("Max Act => "+ maxAct);

    // //Printing Exactly What were the Activities
    // //By Traversing ArrayList
    // for(int i=0; i<ansAct.size(); i++) {
    //     System.out.println("A"+ansAct.get(i));
    // }





    //ASSUMPTION => ****************Activities are not Sorted by their END TIME*****************
    //TC = 0(nlogn)
    int startTime[] = {1,3,0,5,8,5};
    int endTime[] = {2,4,6,7,9,9};

    //Sorting 
    int activities[][] = new int[startTime.length][3];

    for(int i=0; i<startTime.length; i++) {
        activities[i][0] = i;
        activities[i][1] = startTime[i];
        activities[i][2] = endTime[i];
    }

    //Lambda Fuction WHICH IS ShortForm of a BIG Fuction
    Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
    int maxAct = 0;
    ArrayList<Integer> ansAct = new ArrayList<>();

    //Default Select 1st Act -> then 
    //1st Activity - The first activity always gets selected
    maxAct = 1;
    ansAct.add(activities[0][0]);  //choosing 1st Act 

    int lastEnd = activities[0][2];
    //As we Know last Act's Time should be small or equal to my current Act OR
    //My Current Act's Start point should be greater than or equal to my prev Act's EndTime
    for(int i=1; i<endTime.length; i++) {
       if(activities[i][1] >= lastEnd) {
        //Select Activity
        maxAct++;
        ansAct.add(activities[i][0]);
        lastEnd = activities[i][2];
       }
    }
    System.out.println("Max Act => "+ maxAct);

    //Printing Exactly What were the Activities
    //By Traversing ArrayList
    for(int i=0; i<ansAct.size(); i++) {
        System.out.println("A"+ansAct.get(i));
    }
}
}
