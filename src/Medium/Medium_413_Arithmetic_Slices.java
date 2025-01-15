// 413. Arithmetic Slices
package Medium;

public class Medium_413_Arithmetic_Slices  {
    public static int numberOfArithmeticSlices(int[] nums) {
        // Slice minimum length = 3
        int n = nums.length;
        if (n < 3) return 0;

        int count = 2;
        int diff = nums[1] - nums[0];
        int answer = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                count++;
            } else {
                if (count >= 3)
                    answer += (count - 2) * (count - 2 + 1) / 2; // number of sub-arrays possible
                count = 2;
                diff = nums[i] - nums[i - 1];
            }
        }
        if (count >= 3)
            answer += (count - 2) * (count - 2 + 1) / 2;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4}));
        System.out.println(numberOfArithmeticSlices(new int[]{1}));
    }
}
