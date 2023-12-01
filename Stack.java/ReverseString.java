import java.util.*;
import java.util.Stack;

public class ReverseString{

public static String reverseString(String str){
    Stack<Character> s = new Stack<Character>();
    for(int i=0; i<str.length(); i++){
        s.push(str.charAt(i));
    }
    StringBuilder newStr = new StringBuilder("");
    while(!s.isEmpty()){
        char curr = s.pop();
        newStr.append(curr);
    }
    return newStr.toString();
}
   public static void main(String args[]){
       String str = "Saloni";
       System.out.println(reverseString(str));
   }
}