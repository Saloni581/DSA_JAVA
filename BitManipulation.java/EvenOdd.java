public class EvenOdd {
    
    public static void main(String args[]){
           int num = 1010;
           int bitMask = 1;
           if((num & bitMask) == 0){
            System.out.println("Even Number");
           }
           else{
            System.out.println("Odd number");
           }
    }
}
