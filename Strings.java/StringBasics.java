import java.util.*;
public class StringBasics{

    public static void main(String args[]){
    //Methods of creating and initializing a string 
    String str = "Saloni";
    String str1 = new String("Lathwariya");
    System.out.println(str + " " + str1);


    String newStr = new String("");

    //Length function for Strings
    for(int i=0; i<str.length(); i++){
       newStr += str.charAt(i);
    }
    System.out.println(newStr);
    

    //Concatenation
    String concate = str + " " + str1;
    System.out.println(concate);

    //For finding sunstrings
    String sub = str.substring(2, 4);
   
}
}