// 1004. Max Consecutive Ones III
package Medium;

public class Medium_1004_Max_Consecutive_Ones_III {
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int count = 0;
        int maxCount = 0;
        while (right < nums.length) {
            if (nums[right] == 0)
                count++;
            while (count > k) {
                if (nums[left] == 0)
                    count--;
                left++;
            } maxCount = Math.max(maxCount, right-left+1);
            right++;
        } return maxCount;
    }
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}