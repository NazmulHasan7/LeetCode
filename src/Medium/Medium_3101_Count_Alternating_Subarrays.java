// 3101. Count Alternating Subarrays
package Medium;

public class Medium_3101_Count_Alternating_Subarrays {
    public static long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        int left = 0, right = 1;
        long count = 0;

        while (right < n) {
            if (nums[right] == nums[right - 1]) {
                int x = right - left;
                count += ((long) x * (x + 1)) / 2;
                left = right;
            }
            right++;
        }
        int x = right - left;
        count += ((long) x*(x+1)) / 2;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countAlternatingSubarrays(new int[]{0,1,1,1}));
        System.out.println(countAlternatingSubarrays(new int[]{1,0,1,0}));
    }
}
