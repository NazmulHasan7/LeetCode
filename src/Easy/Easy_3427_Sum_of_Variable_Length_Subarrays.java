// 3427. Sum of Variable Length Subarrays
package Easy;

public class Easy_3427_Sum_of_Variable_Length_Subarrays {
    public static int subarraySum(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int preSum = 0;

        for (int i=0; i<n; i++) {
            preSum += nums[i];
            prefix[i] = preSum;
        }

        int answer = 0;
        for (int i=0; i<n; i++) {
            int start = Math.max(0, i-nums[i]);
            if (start == 0) {
                answer += prefix[i];
            } else {
                answer += (prefix[i] - prefix[start-1]);
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{2,3,1}));
        System.out.println(subarraySum(new int[]{3,1,1,2}));
    }
}
