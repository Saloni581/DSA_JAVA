
public class AssignMent{
public static void main(String args[]){
    //1
    //Calculate x^x for each value of x
    //    int x = 1;
    //    System.out.println(x^x);

    //2
    //Swap without using 3rd operator
    //Can be solved very easily using XOR operator

    // int x = 8;
    // System.out.println("X is " + x);
    // int y = 7;
    // System.out.println("Y is " + y);
    // x = x^y;
    // y = x^y;
    // x = x^y;
    // System.out.println("X is now  " + x);
    // System.out.println("Y is now  " + y);

    //3
    //Add 1 to an Integer using ~

    // int x = 6;
    // System.out.println(-~x);
    // x = 0;
    // System.out.println(-~x);

    //4
    //LowerCase to UpperCase 

    // for(char ch='A'; ch<='Z'; ch++){
    //     System.out.print((char) (ch | ' ') +" ");
    // }
    
    // System.out.print((int)'a');//97
    // System.out.print((int)'A');//65
    // ' ' = 32 
    System.out.print((char)(66 | 32));
    System.out.print((char)(67 | 32));
    System.out.print((char)(68 | 32));
}
}