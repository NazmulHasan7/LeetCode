// 1979. Find Greatest Common Divisor of Array
package Easy;

public class Easy_1979_Find_Greatest_Common_Divisor_of_Array {
    public static int findGCD(int[] nums) {
        // Find minimum maximum
        int min = nums[0], max = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] < min)
                min = nums[i];
            else if (nums[i] > max)
                max = nums[i];
        }
        // Calculate GCD
        int temp;
        while (min != 0) {
            temp = min;
            min = max % min;
            max = temp;
        } return max;
    }
    public static void main(String[] args) {
        System.out.println(findGCD(new int[] {2,5,6,9,10}));
        System.out.println(findGCD(new int[] {7,5,6,8,3}));
        System.out.println(findGCD(new int[] {3,3}));
    }
}
