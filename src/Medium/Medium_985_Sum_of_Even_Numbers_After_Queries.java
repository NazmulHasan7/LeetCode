// 985. Sum of Even Numbers After Queries
package Medium;
import java.util.Arrays;

public class Medium_985_Sum_of_Even_Numbers_After_Queries {
    public static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int sum = 0;
        int[] answer = new int[n];
        for (int x : nums)
            if ((x & 1) == 0) sum += x;

        for (int i=0; i<n; i++) {
            int idx = queries[i][1];
            int value = queries[i][0];

            if ((nums[idx] & 1) == 0) {
                sum -= nums[idx];
            }
            nums[idx] += value;
            if ((nums[idx] & 1) == 0)
                sum += nums[idx];

            answer[i] = sum;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumEvenAfterQueries(new int[]{1, 2, 3, 4},
                new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}})));
        System.out.println(Arrays.toString(sumEvenAfterQueries(new int[]{1}, new int[][]{{4,0}})));
    }
}
