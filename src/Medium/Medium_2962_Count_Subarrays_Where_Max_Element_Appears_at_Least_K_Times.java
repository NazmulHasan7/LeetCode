// 2962. Count Subarrays Where Max Element Appears at Least K Times
package Medium;

public class Medium_2962_Count_Subarrays_Where_Max_Element_Appears_at_Least_K_Times {
    public static long countSubarrays(int[] nums, int k) {
        long answer = 0;
        int count = 0;
        int left = 0, right = 0, maxNumber = 0;
        int n = nums.length;

        for (int num : nums)
            if (num > maxNumber) maxNumber = num;

        while (right < n) {
            if (nums[right] == maxNumber)
                count++;

            while (count >= k) {
                // Since it is a valid window, all the sub-arrays to it right are also counted
                answer += n-right;
                if (nums[left] == maxNumber)
                    count--;
                left++;
            } right++;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,3,2,3,3}, 2));
        System.out.println(countSubarrays(new int[]{1,4,2,1}, 3));
    }
}
