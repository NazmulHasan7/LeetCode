// 645. Set Mismatch
package Easy;
import java.util.Arrays;

public class Easy_645_Set_Mismatch {
    public static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[2];
        int actSum = 0;

        int n = nums.length;
        for (int i=0; i<n-1; i++) {
            if (nums[i] == nums[i+1])
                result[0] = nums[i];
            actSum += nums[i];
        } actSum += nums[n-1];

        int expectedSum = (n*(n+1))/2;
        result[1] = expectedSum - (actSum - result[0]);
        return result;
    }
    public static int[] findErrorNumsBetter(int[] nums) {
        int[] result = new int[2];
        int n = nums.length;
        int[] freq = new int[n+1];
        for (int num : nums) freq[num]++;

        for (int i=1; i<=n; i++) {
            if (freq[i] == 2) result[0] = i;
            else if (freq[i] == 0) result[1] = i;
        } return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[] {1,2,2,4})));
        System.out.println(Arrays.toString(findErrorNumsBetter(new int[] {1,2,2,4})));
    }
}
