// 1780. Check if Number is a Sum of Powers of Three
package Medium;

public class Medium_1780_Check_if_Number_is_a_Sum_of_Powers_of_Three {
    // Backtracking approach TC -> O(2^log3(n)) -> O(n)
    public static boolean checkPowersOfThree(int n) {
        return solve(0, n);
    }
    private static boolean solve(int power, int n) {
        if (n == 0) return true;

        int value = (int) Math.pow(3, power);
        if (value > n) return false;

        boolean takePower = solve(power+1, n-value);
        boolean skipPower = solve(power+1, n);
        return takePower || skipPower;
    }
    // Iterative Approach TC -> O(log3(n))
    public static boolean checkPowersOfThreeOpt(int n) {
        int power = 0;
        while (Math.pow(3, power) <= n)
            power++;

        while (n > 0) {
            int value = (int) Math.pow(3, power);
            if (n >= value) n -= value;
            // cannot use the same power twice
            if (n >= value) return false;
            power--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(12));
        System.out.println(checkPowersOfThree(91));
        System.out.println(checkPowersOfThree(21));
    }
}
