// 3487. Maximum Unique Subarray Sum After Deletion
package Easy;
import java.util.HashSet;

public class Easy_3487_Maximum_Unique_Subarray_Sum_After_Deletion {
    public static int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > 0) set.add(num);
            max = Math.max(max, num);
        }
        if (set.isEmpty()) return max;

        int answer = 0;
        for (int num : set) answer += num;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{1,2,3,4,5}));
        System.out.println(maxSum(new int[]{1,1,0,1,1}));
        System.out.println(maxSum(new int[]{1,2,-1,-2,1,0,-1}));
    }
}
