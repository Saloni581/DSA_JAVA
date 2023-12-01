import java.util.*;
import java.util.ArrayList;

public class S_ArrayList{

    static class ArrayListStack{
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty(){
               return list.size() == 0;
        }

        //push
        public static void push(int data){
            list.add(data);
        }
        //pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        //peek

        public static int peek(){
            // int top = list.get(list.size()-1);
            // return top;
            //           ||
             if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    public static void main(String args[]){
       ArrayListStack s = new ArrayListStack();
       s.push(1);
       s.push(2);
       s.push(3);
       s.push(4);
       s.push(5);
       while(!s.isEmpty()){
        System.out.println(s.peek());
        s.pop();
       }
    }
}