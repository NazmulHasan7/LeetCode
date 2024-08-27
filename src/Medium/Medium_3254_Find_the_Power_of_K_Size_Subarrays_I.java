// 3254. Find the Power of K-Size Sub-arrays I
package Medium;
import java.util.Arrays;

public class Medium_3254_Find_the_Power_of_K_Size_Subarrays_I {
    public static int[] resultsArray(int[] nums, int k) {
        // Two pointer + Sliding window approach
        int n = nums.length;
        if (k == 1) return nums;
        int[] result = new int[n-k+1];
        Arrays.fill(result, -1);

        int i=0, j=1;
        while (j < n) {
            if (nums[j] - nums[j-1] == 1) {
                // case 1 -> consecutive and within the window
                if (j < i+k-1) {
                    j++; // increment j
                } else if (j == i+k-1) {
                    // case 2 -> reached the window size
                    result[i] = nums[j];
                    i++; j++; // slide the window
                }
            } else {
                // case 3 -> violation of consecutive property
                i = j; // no need the check the previous elements
                j++; // start new window from current element
            }
        } return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(resultsArray(new int[]{1, 2, 3, 4, 3, 2, 5}, 3)));
        System.out.println(Arrays.toString(resultsArray(new int[]{2,2,2,2,2}, 4)));
        System.out.println(Arrays.toString(resultsArray(new int[]{3,2,3,2,3,2}, 2)));
    }
}
