// 2614. Prime In Diagonal
package Easy;

public class Easy_2614_Prime_In_Diagonal {
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        for (int i=2; i*i<=num; i++)
            if (num % i == 0) return false;
        return true;
    }
    public static int diagonalPrime(int[][] nums) {
        int maxPrime = 0;
        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (nums[i][i] > maxPrime && isPrime(nums[i][i]))
                maxPrime = nums[i][i];
            if (nums[i][n-i-1] > maxPrime && isPrime(nums[i][n-i-1]))
                maxPrime = nums[i][n-i-1];
        } return maxPrime;
    }
    public static void main(String[] args) {
        System.out.println(diagonalPrime(new int[][] {{1,2,3},{5,6,7},{9,10,11}}));
        System.out.println(diagonalPrime(new int[][] {{1,2,3},{5,17,7},{9,11,10}}));
    }
}
