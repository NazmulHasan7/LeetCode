// 3152. Special Array II
package Medium;
import java.util.Arrays;

public class Medium_3152_Special_Array_II {
    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] answer = new boolean[queries.length];
        int[] ps = new int[nums.length];

        for (int i=1; i<nums.length; i++) {
            // parity within a valid sub-array should always be the same
            ps[i] = ps[i-1];
            if (nums[i-1] % 2 == nums[i] % 2)
                ps[i]++;
        }
        for(int i=0; i<queries.length; i++){
            int from = queries[i][0],to = queries[i][1];
            answer[i] = ps[to] - ps[from] == 0;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(isArraySpecial(new int[]{3,4,1,2,6},new int[][]{{0,4}})));
        System.out.println(Arrays.toString(isArraySpecial(new int[]{4,3,1,6},new int[][]{{0,2},{2,3}})));
    }
}
