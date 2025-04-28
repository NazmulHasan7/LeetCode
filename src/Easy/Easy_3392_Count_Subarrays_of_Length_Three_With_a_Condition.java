// 3392. Count Subarrays of Length Three With a Condition
package Easy;

public class Easy_3392_Count_Subarrays_of_Length_Three_With_a_Condition {
    public static int countSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i=0; i<n-2; i++) {
            int first = nums[i];
            int second = nums[i+1];
            int third = nums[i+2];
            if ((first + third) * 2 == second)
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,2,1,4,1}));
        System.out.println(countSubarrays(new int[]{1,1,1}));
    }
}
