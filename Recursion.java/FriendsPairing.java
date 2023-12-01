public class FriendsPairing {
    

    public static int friendsPairing(int n){
        //Base Case
        if(n == 1 || n == 2){
            return n;
        }
        //Single = n-1 choices
        //pair = n-1 choices and after making pair = n-2 ways h
        return friendsPairing(n-1)+friendsPairing(n-1)*friendsPairing(n-2);
    }
    public static void main(String args[]){
           System.out.println(friendsPairing(3));
    }
}
