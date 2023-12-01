import java.util.*;

public class JobSequencingProblem {
    
    static class Job {
    int deadline;
    int profit;
    int id;

    public Job(int i, int d, int p) {
        deadline = d;
        profit = p;
        id = i;
    }
}


public static void main(String args[]) {
    int givenJob[][] = {{4, 20}, {1, 20}, {1, 40}, {1,30}};
    ArrayList<Job> job = new ArrayList<>();

    //Adding all givenJob[][] elms in ArrayList of job
    for(int i=0; i<givenJob.length; i++) {
        //Passing in Comparator
        job.add(new Job(i, givenJob[i][0], givenJob[i][1]));
    }
    //MAIN LEARNING FROM HERE = How to apply sorting on **********"OBJECTS"**************
    //Descending Order Sorting of Objects
    Collections.sort(job, (obj1, obj2) -> obj2.profit - obj1.profit);

    ArrayList<Integer> seq = new ArrayList<>();
    int time = 0;
    for(int i=0; i<job.size(); i++) {
        Job curr = job.get(i);
        if(curr.deadline > time) {
           seq.add(curr.id);
           time++;
        }
    }

    System.out.println("Maximum Jobs = "+ seq.size());
    for(int i=0; i<seq.size(); i++) {
        System.out.println(seq.get(i)+" ");
    }
    System.out.println();
}
}
