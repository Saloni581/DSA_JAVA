import java.util.*;

public class strSubsets{
       
       public static void findSubsets(String s, String ans, int i){
        //Base Case
        if(i == s.length()){
            if(ans.length() == 0){
                System.out.println("Zero");
            }
            else{
              System.out.println(ans);
            }
            return;
        }
        //Recursion and Backtracking 
        //Yes Choice
        findSubsets(s, ans+s.charAt(i), i+1);
        //No Choice
        findSubsets(s, ans, i+1);
       }
    public static void main(String args[]){
        String str = "abc";
        findSubsets(str, " ",0);
    }
}