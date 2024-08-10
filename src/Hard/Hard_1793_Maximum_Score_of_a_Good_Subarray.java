// 1793. Maximum Score of a Good Sub-array
package Hard;

public class Hard_1793_Maximum_Score_of_a_Good_Subarray {
    public static int maximumScore(int[] nums, int k) {
        int i = k, j = k, n = nums.length-1;
        int min = nums[k];
        int answer = nums[k];

        // Two pointer approach
        while (i > 0 || j < n) {
            if (i == 0) j++;
            else if (j == n) i--;
            else if (nums[i-1] < nums[j+1]) j++;
            else i--;

            // update minimum and answer
            min = Math.min(min, Math.min(nums[i], nums[j]));
            answer = Math.max(answer, min*(j-i+1));
        } return answer;
    }
    public static int maximumScoreBetter(int[] nums, int k) {
        int i = k-1, j = k+1, n = nums.length;
        int min = nums[k];
        int answer = nums[k];

        // Two pointer approach
        while (i >= 0 || j < n) {
            if (i == -1) {
                min = Math.min(min, nums[j++]);
            } else if (j == n) {
                min = Math.min(min, nums[i--]);
            } else if (nums[i] < nums[j]) {
                min = Math.min(min, nums[j++]);
            } else {
                min = Math.min(min, nums[i--]);
            }
            answer = Math.max(answer, min * (j-i-1));
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(maximumScoreBetter(new int[]{1,4,3,7,4,5},3));
        System.out.println(maximumScoreBetter(new int[]{5,5,4,5,4,1,1,1},0));
    }
}
