import java.util.*;
public class PalinDromeStr {
    
    public static boolean isPalindrome(String str){

           for(int i=0; i<str.length()/2; i++){
              if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
              }
           }
           return true;
    }
    public static void main(String args[]){
            String palin = "noon";
            String nonPalin = "saloni";
            System.out.println(isPalindrome(palin));
            System.out.println(isPalindrome(nonPalin));
    }
}
