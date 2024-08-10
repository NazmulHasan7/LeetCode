// 2134. Minimum Swaps to Group All 1's Together II
package Medium;

public class Medium_2134_Minimum_Swaps_to_Group_All_1s_Together_II {
    public static int minSwaps(int[] nums) {
        int count1 = 0;
        for (int num : nums) count1 += num;

        // Total 1's in the array is count1
        // The window will be of size count1
        int count0 = 0;
        // Calculate the swaps in first window
        int left = 0, right = 0;
        while (right < count1) {
            if (nums[right] == 0) count0++;
            right++;
        }
        int answer = count0;
        left++;
        int n = nums.length;
        // Calculate for the rest of the window
        while (right < 2 * n) {
            if (nums[right % n] == 0) count0++;
            if (nums[left %  n] == 0) count0--;
            answer = Math.min(answer, count0);
            left++;
            right++;
        } return answer;
    }
    public int minSwapsBetter(int[] nums) {
        int count1 = 0;
        for (int n : nums) count1 += n;
        int n = nums.length;

        int windowCount1 = 0;
        for(int i=0; i<count1; i++)
            windowCount1 += nums[i];

        int answer = windowCount1;
        int right = count1;
        while (right < n + count1) {
            windowCount1 += nums[right%n] - nums[(right-count1+n)%n];
            answer = Math.max(answer, windowCount1);
            right++;
        }
        return count1 - answer;
    }
    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{0,1,0,1,1,0,0}));
        System.out.println(minSwaps(new int[]{0,1,1,1,0,0,1,1,0}));
        System.out.println(minSwaps(new int[]{1,1,0,0,1}));
    }
}
