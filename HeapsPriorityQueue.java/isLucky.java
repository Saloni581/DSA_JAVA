public class isLucky {
 
    public static boolean isLuckyNum(int n) {

        int count = 2;  //in every itr count++
        while(true) {
            if(n % count == 0) { // 1st condition is to check if num is even (bcoz even nums are not lucky)
                return false;
            }
            if(count > n) {   // 2nd condition is to check if count greater than me than I am inside the count and safe 
                return true;//Means Lucky as count can never cut me when i am little and inside it
            }
            n = (n-(n/count)); // 3rd is to update variable n according to How likely there is chances to cut me
            count++;//updating count + 1 in each step
        }
    }
    public static void main(String args[]) {
        int n = 1;
        System.out.println(isLuckyNum(n));
    }
}
