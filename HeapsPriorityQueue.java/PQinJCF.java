import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.*;

public class PQinJCF {

    static class Student implements Comparable<Student> {
           String name;
           int rank;
           public Student(String name, int rank) {
                 this.name = name;
                 this.rank = rank;
           }

           @Override
           public int compareTo(Student s) {
             return this.rank - s.rank;
           }
    }

    public static void main(String args[]) {
        //PriorityQueue<Integer> pq = new PriorityQueue<>();
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("abc", 13));
        pq.add(new Student("sdf", 8));
        pq.add(new Student("tyu", 5));
        pq.add(new Student("fgr", 72));

        while(!pq.isEmpty()) {
            System.out.println(pq.peek().name+"->"+pq.peek().rank);
            pq.remove();
        }
    }
}