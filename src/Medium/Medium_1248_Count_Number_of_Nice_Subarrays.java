// 1248. Count Number of Nice Subarrays
package Medium;

public class Medium_1248_Count_Number_of_Nice_Subarrays {
    public static int numberOfSubarraysBetter(int[] nums, int k) {
        int answer = 0;
        int left = 0, right = 0, count = 0, windowCount = 0;

        while (right < nums.length) {
            if (nums[right] % 2 == 1) {
                count++;
                // windowCount keeps track of the number of nice sub-arrays within the current window
                windowCount = 0;
            }
            while (count == k && left <= right) {
                // Whenever a nice sub-array is found within the current window
                windowCount++;
                if (nums[left] % 2 == 1)
                    count--;
                left++;
            }
            answer += windowCount;
            right++;
        } return answer;
    }
    // https://www.youtube.com/watch?v=XnMdNUkX6VM --> After 7:30 min
    public static int countSubarrays(int[] nums, int k) {
        int answer = 0;
        int left = 0, right = 0, count = 0;

        while (right < nums.length) {
            if (nums[right] % 2 == 1)
                count++;
            while (count > k) {
                if (nums[left] % 2 == 1)
                    count--;
                left++;
            } answer += (right-left+1);
            right++;
        } return answer;
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        return countSubarrays(nums, k) - countSubarrays(nums, k-1);
    }
    public static void main(String[] args) {
        System.out.println(numberOfSubarraysBetter(new int[]{1,1,2,1,1}, 3));
        System.out.println(numberOfSubarraysBetter(new int[]{2,4,6}, 1));
        System.out.println(numberOfSubarraysBetter(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
    }
}
