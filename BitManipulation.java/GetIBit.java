public class GetIBit {
    
    public static int getIthbit(int num, int i){
           int bitmask = 1<<i;
           return num & bitmask;
    }
    public static void main(String args[]){
        System.out.println(getIthbit(10, 3));
    }
}
