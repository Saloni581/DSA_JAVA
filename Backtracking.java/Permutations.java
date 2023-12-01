import java.util.*;

public class Permutations{

    public static void findPermutations(String str, String ans){
        //Base Case 
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        //Recursion
        for(int i=0; i<str.length(); i++){
            //picking ith char to place
            char curr = str.charAt(i);
            //Removing picked char from str
            String newStr = str.substring(0,i)+str.substring(i+1);//By default if we do not provide 2nd variation to substring function it is considered as n-1
            //Recusion
            findPermutations(newStr,ans+curr);
    }
    }
    public static void main(String args[]){
           String s = "abc";
           findPermutations(s, "");
    }
}