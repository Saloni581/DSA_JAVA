public class ClearLastIBits {
    
    public static int clearLastBits(int n, int i){
           
        int bitmask = (~0) << i;
        return n & bitmask;
    }

    public static void main(String  args[]){
           System.out.println(clearLastBits(5, 2));
    }
}
