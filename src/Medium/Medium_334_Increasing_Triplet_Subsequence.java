// 334. Increasing Triplet Subsequence
package Medium;

public class Medium_334_Increasing_Triplet_Subsequence {
    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;

        int num1 = Integer.MAX_VALUE,
                num2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= num1) {
                num1 = num;
            } else if (num <= num2) {
                num2 = num;
            } else {
                return true;
            }
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println(increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println(increasingTriplet(new int[]{2,1,5,0,4,6}));
    }
}
