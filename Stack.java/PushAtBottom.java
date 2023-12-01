import java.util.*;
import java.util.Stack;

public class PushAtBottom{

    //0(n)
public static void pushBottom(Stack<Integer> s,int data){
   
    if(s.isEmpty()){
        s.push(data);
        return;
    }
    int top = s.pop();
    pushBottom(s, data); //recursive step
    s.push(top);
}
   public static void main(String args[]){
       Stack<Integer> s = new Stack<>();
       s.push(1);
       s.push(2);
       s.push(3);
       s.push(4);
       s.push(5);
       pushBottom(s, 2);
       while(!s.isEmpty()){
        System.out.println(s.pop());
       }
   }
}