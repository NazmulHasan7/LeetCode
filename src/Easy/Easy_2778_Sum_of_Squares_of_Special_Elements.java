// 2778. Sum of Squares of Special Elements
package Easy;

public class Easy_2778_Sum_of_Squares_of_Special_Elements {
    public static int sumOfSquares(int[] nums) {
        int sum = 0;
        for (int i=0; i< nums.length; i++)
            if (nums.length % (i+1) == 0)
                sum += nums[i] * nums[i];
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sumOfSquares(new int[] {1,2,3,4}));
        System.out.println(sumOfSquares(new int[] {2,7,1,19,18,3}));
    }
}
