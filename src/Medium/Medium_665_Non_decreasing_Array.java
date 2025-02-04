// 665. Non-decreasing Array
package Medium;

public class Medium_665_Non_decreasing_Array {
    public static boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int modifyCount = 0;

        // check for non-decreasing
        for (int i=1; i<n; i++) {
            if (nums[i] < nums[i-1]) {
                modifyCount++;
                if (modifyCount > 1) return false;

                // Decide which one to modify i-1 or i-2
                // 2 4 1 -> 2 4 4, 1 4 2 -> 1 2 2
                if (i >= 2 && nums[i] < nums[i-2]) {
                    nums[i] = nums[i-1];
                } else {
                    nums[i-1] = nums[i];
                }
            }
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4,2,3}));
        System.out.println(checkPossibility(new int[]{4,2,1}));
    }
}
