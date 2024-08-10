// 2966. Divide Array Into Arrays With Max Difference
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_2966_Divide_Array_Into_Arrays_With_Max_Difference {
    public static int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] answer = new int[n/3][3];
        Arrays.sort(nums);

        int i = 0, idx = 0;
        while (i < n) {
            int num1 = nums[i++];
            int num2 = nums[i++];
            int num3 = nums[i++];

            if (num3 - num1 <= k) {
                answer[idx][0] = num1;
                answer[idx][1] = num2;
                answer[idx][2] = num3;
                idx++;
            } else {
                return new int[0][0];
            }
        } return answer;
    }
    public int[][] divideArrayBetter(int[] nums, int k) {
        Arrays.sort(nums);
        List<int[]> answer = new ArrayList<>();
        for (int i=2; i<nums.length; i+=3) {
            if (nums[i] - nums[i-2] > k)
                return new int[][]{};

            answer.add(new int[]{nums[i-2], nums[i-1], nums[i]});
        } return answer.toArray(new int[answer.size()][]);
    }
    public static void main(String[] args) {
        int[][] answer = divideArray(new int[]{1,3,4,8,7,9,3,5,1}, 2);
        for (int[] arr : answer)
            System.out.println(Arrays.toString(arr));
        answer = divideArray(new int[]{1,3,3,2,7,3}, 2);
        for (int[] arr : answer)
            System.out.println(Arrays.toString(arr));
    }
}
