// 962. Maximum Width Ramp
package Medium;

public class Medium_962_Maximum_Width_Ramp {
    // Brute Force -> O(n^2)
    public static int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int answer = 0;

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (nums[j] >= nums[i])
                    answer = Math.max(answer, j-i);
            }
        } return answer;
    }
    // Two-pointer approach -> O(n)
    public static int maxWidthRampOpt(int[] nums) {
        int n = nums.length;
        int answer = 0;

        int[] rightMax = new int[n];
        rightMax[n-1] = nums[n-1];

        for (int i=n-2; i>=0; i--)
            rightMax[i] = Math.max(rightMax[i+1], nums[i]);

        // two pointer approach
        int left = 0, right = 0;
        while (right < n) {
            while (left < right && nums[left] > rightMax[right])
                left++;
            answer = Math.max(answer, right-left);
            right++;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(maxWidthRamp(new int[]{6,0,8,2,1,5}));
        System.out.println(maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1}));
    }
}
