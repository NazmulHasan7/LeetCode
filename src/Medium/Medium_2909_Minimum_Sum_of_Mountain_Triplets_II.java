// 2909. Minimum Sum of Mountain Triplets II
package Medium;

public class Medium_2909_Minimum_Sum_of_Mountain_Triplets_II {
    public static int minimumSum(int[] nums) {
        int n = nums.length;
        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        int[] rightMin = new int[n];
        rightMin[n-1] = nums[n-1];

        for (int i=1; i<n; i++) {
            leftMin[i] = Math.min(leftMin[i-1], nums[i]);
            rightMin[n-i-1] = Math.min(rightMin[n-i], nums[n-i-1]);
        }

        int answer = Integer.MAX_VALUE;
        for (int i=1; i<n-1; i++) {
            if (leftMin[i-1] < nums[i] && nums[i] > rightMin[i+1])
                answer = Math.min(answer, leftMin[i-1] + nums[i] + rightMin[i+1]);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    public static void main(String[] args) {
        System.out.println(minimumSum(new int[]{8,6,1,5,3}));
        System.out.println(minimumSum(new int[]{5,4,8,7,10,2}));
        System.out.println(minimumSum(new int[]{6,5,4,3,4,5}));
    }
}
