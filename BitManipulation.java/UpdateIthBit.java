public class UpdateIthBit {

    public static int clearIthBit(int n, int i){
        int bitmask = ~(1<<i);
        return n & bitmask;
    }

    public static int setIthbit(int n, int i){
        int bitmask = 1<<i;
        return n | bitmask;
    }

    public static int updateIthBit(int n, int i, int newBit){
        //1st Approach
        //    if(newBit == 0){
        //       clearIthBit(n, i);
        //    }
        //    else{
        //       setIthbit(n, i);
        //    }


        // 2nd Approach

        n = clearIthBit(n, i);
        int bitmask = newBit<<i;
        return n | bitmask;

    }

    public static void main(String args[]){
    
          System.out.println(updateIthBit(10, 2, 1));
    }
}
