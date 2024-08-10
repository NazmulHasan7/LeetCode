// 1508. Range Sum of Sorted Subarray Sums
package Medium;
import java.util.Arrays;

public class Medium_1508_Range_Sum_of_Sorted_Subarray_Sums {
    public static int rangeSum(int[] nums, int n, int left, int right) {
        int index = 0;
        int[] answer = new int[n*(n+1)/2];

        for (int i=0; i<n; i++) {
            int currentSum = 0;
            for (int j=i; j<n; j++) {
                currentSum += nums[j];
                answer[index++] = currentSum;
            }
        }
        Arrays.sort(answer);
        int sum = 0;
        for (int i=left-1; i<right; i++)
            sum = (sum + answer[i]) % 1000000007;
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(rangeSum(new int[]{1,2,3,4}, 4,1,5));
        System.out.println(rangeSum(new int[]{1,2,3,4}, 4,3,4));
        System.out.println(rangeSum(new int[]{1,2,3,4}, 4,1,10));
    }
}
