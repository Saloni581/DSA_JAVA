import java.util.*;
public class AssignMent {
    

    //1
    //Find occurence of lowerCase vowels
    public static int lowercaseVowels(String str){
            int count = 0;
           for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'o' || str.charAt(i) == 'u' ||
            str.charAt(i) == 'i'|| str.charAt(i) == 'e'){
               count++;
            } 
           }
           return count;
    }

    //4
    //Anagrams Strings 
    public static void isAnagrams(String str1, String str2){
        // 0th step
          str1 = str1.toUpperCase();
          str2 = str2.toUpperCase();

        // 1st step
        if(str1.length() == str2.length()){
            // 2nd step
            char str1Array[] = str1.toCharArray();
            char str2Array[] = str2.toCharArray();

            // 3rd step
            Arrays.sort(str1Array);
            Arrays.sort(str2Array);

            // 4th step
            boolean result = Arrays.equals(str1Array, str2Array);

            // last step
            if(result){
                System.out.println("Strings are anagrams");
            }
            else{
                System.out.println("Strings are not anagrams");
            }
        }

        else{
            System.out.println("Strings are not equal");
        }
    }
    public static void main(String args[]){
        //1
        //    Scanner sc = new Scanner(System.in);
        //    String str = sc.nextLine();
        //    System.out.println("The number of LowerCase Vowels in string : "+lowercaseVowels(str));

           //2
           //Analyzing code snipet
        //    String str = "ShradhaDidi";
        //    String str1 = "ApnaCollege";
        //    String str2 = "ShradhaDidi";
        //    System.out.println(str.equals(str1)+ " " + str.equals(str2));

        //3
        //Analyzing code snipet
        // String str = "ApnaCollege".replace("l", "");
        // System.out.println(str);


        //4
        String str1 = "race";
        String str2 = "care";
        String str3 = "saloni";
        String str4 = "payal";
        isAnagrams(str1, str2);
        isAnagrams(str3, str4);
        
     }
}
