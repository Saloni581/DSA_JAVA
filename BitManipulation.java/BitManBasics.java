import java.util.*;

 public class BitManBasics{

    public static int binaryToDecimal(int binary) {
        int decimal = 0;
        int power = 0;
        while (binary != 0) {
            int lastDigit = binary % 10;
            decimal += lastDigit * Math.pow(2, power);
            power++;
            binary /= 10;
        }
        return decimal;
    }

    public static int decimalToBinary(int decimal) {
        int binary = 0;
        int power = 1;
        while (decimal != 0) {
            int lastDigit = decimal % 2;
            binary += lastDigit * power;
            power *= 10;
            decimal /= 2;
        }
        return binary;
    }
    
    
    public static void main(String args[]){
        System.out.println(5 & 6);
        System.out.println(5 | 6);
        System.out.println(~5);
        System.out.println(5^6);
        System.out.println(5<<2);
        System.out.println(5>>2);
    }
}