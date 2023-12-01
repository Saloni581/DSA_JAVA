// A class to store the factorials of numbers up to n
class Factorial {
    // An array to store the factorials
    int[] dp;

    // A constructor to initialize the array
    public Factorial(int n) {
        // Allocate memory for the array
        dp = new int[n+1];

        // Base case: 0! = 1
        dp[0] = 1;

        // Calculate the factorials of numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] * i;
        }
    }

    // A method to return the factorial of a number
    public int getFactorial(int n) {
        // Return the value stored in the array
        return dp[n];
    }
}

// A class to test the Factorial class
public class Test {
    public static void main(String[] args) {
        // Create an object of Factorial class with n = 10
        Factorial f = new Factorial(30);

        // Print the factorials of some numbers
        System.out.println("Factorial of 5 is " + f.getFactorial(5));
        System.out.println("Factorial of 7 is " + f.getFactorial(7));
        System.out.println("Factorial of 10 is " + f.getFactorial(26));
    }
}
