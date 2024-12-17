// 2593. Find Score of an Array After Marking All Elements
package Medium;
import java.util.Arrays;
import java.util.Comparator;

public class Medium_2593_Find_Score_of_an_Array_After_Marking_All_Elements {
    public static long findScore(int[] nums) {
        int n = nums.length;

        // Keep values along with indices
        int[][] pairs = new int[n][2];
        for (int i=0; i<n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        // Sort based on the values
        Arrays.sort(pairs, new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        boolean[] visited = new boolean[n];
        long answer = 0;
        for (int[] pair : pairs) {
            int value = pair[0];
            int idx = pair[1];

            if (!visited[idx]) {
                answer += value;
                visited[idx] = true;

                if (idx > 0)
                    visited[idx-1] = true;
                if (idx < n-1)
                    visited[idx+1] = true;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(findScore(new int[]{2,1,3,4,5,2}));
        System.out.println(findScore(new int[]{2,3,5,1,3,2}));
    }
}
