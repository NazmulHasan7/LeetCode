// 3282. Reach End of Array With Max Score
package Medium;
import java.util.List;

public class Medium_3282_Reach_End_of_Array_With_Max_Score {
    public static long findMaximumScore(List<Integer> nums) {
        int n = nums.size();
        long score = 0;
        int prev = nums.getFirst();
        int prevIdx = 0;

        for (int i=1; i<n; i++) {
            if (nums.get(i) > prev) {
                score += (long)(i - prevIdx) * prev;
                prev = nums.get(i);
                prevIdx = i;
            }
        }
        if (prevIdx != n-1)
            score += (long)(n-prevIdx-1) * prev;
        return score;
    }
    public static void main(String[] args) {
        System.out.println(findMaximumScore(List.of(1,3,1,5)));
        System.out.println(findMaximumScore(List.of(4,3,1,3,2)));
    }
}
