public class SetIBit {
    
    public static int setIthbit(int n, int i){
            int bitmask = 1<<i;
            return n | bitmask;
    }
    public static void main(String args[]){
        System.out.println(setIthbit(4, 1));
    }
}
